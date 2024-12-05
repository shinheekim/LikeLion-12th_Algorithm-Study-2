#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <map>

using namespace std;
int arr[10001];
int main(void){
    int n,m;
    while(1){
        cin >> n >> m;
        if(n == 0 && m == 0){
            break;
        }
        vector<int> hasScored;
        map<int,int> m1;
        int maxScore = -1;
        for(int i  = 1;i<=10000;i++){
            arr[i] = 0;
        }
        for(int i = 1;i<=n;i++){
            //상위 m명의 랭킹 정보
            //임의의 점수 가중치
           for(int j = 1;j<=m;j++){
               int x;
               cin >> x;
               arr[x] += 1;
               maxScore = max(maxScore,arr[x]);
               hasScored.push_back(x);
           }
        }
        int secondMaxScore = -1;
        for(int i = 0;i<hasScored.size();i++){
            if(arr[hasScored[i]] < maxScore && arr[hasScored[i]] > secondMaxScore){
                secondMaxScore = max(secondMaxScore,arr[hasScored[i]]);
            }
        }
        
        sort(hasScored.begin(),hasScored.end());
        
        for(int i = 0;i<hasScored.size();i++){
            if(secondMaxScore == arr[hasScored[i]] && m1.find(hasScored[i]) == m1.end()){
                cout << hasScored[i] << ' ';
                m1[hasScored[i]] = hasScored[i];
            }
        }
        cout << '\n';
        
        
        
    }
}