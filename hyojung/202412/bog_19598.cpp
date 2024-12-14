#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>

using namespace std;

struct Compare {
    bool operator()(pair<int,int> a,pair<int,int> b){
        return a.second > b.second;
    }
};

int main(void){
    priority_queue<pair<int,int>,vector<pair<int,int>>,Compare> q;
    int n;
    vector<pair<int,int>> v;
    cin >> n;
    
    for(int i = 0;i<n;i++){
        int x,y;
        cin >> x >> y;
        v.push_back({x,y});
    }
    
    sort(v.begin(),v.end());
    
    int count = 0;
    for(int i = 0;i<v.size();i++){
        if(q.empty()){
            q.push({v[i].first,v[i].second});
        }
        else{
            int top = q.top().second;
            if(v[i].first < top){
                count++;
                q.push({v[i].first,v[i].second});
            }
            else{
                q.pop();
                q.push({v[i].first,v[i].second});
            }
        }
       
    }
    cout << q.size();
    
  
    
    
    
    
}