#include <string>
#include <iostream>

using namespace std;
int dx[4] = {0,0,-1,1};
int dy[4] = {1,-1,0,0};

int main(void){
    char arr[1001][1001];
    int n;
    cin >> n;
    for(int i = 1;i<=n;i++){
        for(int j = 1;j<=n;j++){
            cin >> arr[i][j];
        }
    }
    
    int x,y;
    for(int i = 1;i<=n;i++){
        for(int j = 1;j<=n;j++){
            if(arr[i][j] == '*'){
                bool flag = false;
                for(int z = 0;z<4;z++){
                    int nx = i + dx[z];
                    int ny = j + dy[z];
                    if(nx < 1 || ny < 1 || nx > n || ny > n){
                        flag = true;
                        continue;
                    }
                    if(arr[nx][ny] == '_'){
                        flag = true;
                    }
                }
                if(flag == false){
                    x = i;
                    y = j;
                }
            }
        }
    }
    //오른팔
    int mx = 0;
    int my = 0;
    int right_ = 0;
    for(int i = y+1;i<=n;i++){
        if(arr[x][i] == '*'){
            right_++;
        }
        else{
            break;
        }
    }
    
    //왼팔
    int left_ = 0;
    for(int i = y-1;i>=1;i--){
        if(arr[x][i] == '*'){
            left_++;
        }
        else{
            break;
        }
    }
    
    int m = 0;
    for(int i = x+1;i<=n;i++){
        if(arr[i][y] == '_'){
            break;
        }
        else{
            m++;
            my = i;
        }
    }
    //오른다리
    int Right_ = 0;
    for(int i = my+1;i<=n;i++){
      
        if(arr[i][y+1] == '*'){
            Right_++;
        }
        else{
            break;
        }
    }
    
    int Left_ = 0;
    for(int i = my+1;i<=n;i++){
       
        if(arr[i][y-1] == '*'){
            Left_++;
        }
        else{
            break;
        }
    }
   
    
    cout <<x << ' ' << y << '\n';
    cout << left_ << ' ' << right_ << ' ' << m << ' ' << Left_ << ' ' << Right_;
    
}