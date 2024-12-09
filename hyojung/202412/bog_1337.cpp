#include <iostream>
#include <set>
using namespace std;

int main(void){
    int n;
    cin >> n;
    set<int> s;
    set<int>::iterator iter;
    
    for(int i = 0;i<n;i++){
        int x;
        cin >> x;
        s.insert(x);
    }
    
    int maxCount = 987654321;
    for(iter = s.begin();iter != s.end();iter++){
        int next = *iter;
        int count = 4;
        for(int i = 1;i<5;i++){
            if(s.find(next + i) != s.end()){
                count--;
            }
        }
        if(count < maxCount){
            maxCount = count;
        }
        
    }
    cout << maxCount;
}