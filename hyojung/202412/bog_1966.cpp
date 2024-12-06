#include <iostream>
using namespace std;

int main(void) {
    int n;
    cin >> n;
    int num;
    cin >> num;
    int dir = 0;

    int** arr = new int*[n + 1];
    for (int i = 0; i <= n; i++) {
        arr[i] = new int[n + 1]();
    }

    int k = n * n;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 4; j++) {
            for (int z = 1; z <= n; z++) {
                if (j == 0) {
                    if(arr[z][i]){
                        continue;
                    }
                    arr[z][i] = k;
                    k--;
                } else if (j == 1) {
                    if (arr[n-i+1][z]) {
                  
                        continue;
                    }
                    arr[n-i+1][z] = k;
              
                    k--;
                } else if (j == 2) {
                    if(n-z == 0){
                        continue;
                    }
                    if (arr[n - z][n-i+1]) {
                        continue;
                    }
                    arr[n - z][n-i+1] = k;
               
                    k--;
                } else if (j == 3) {
                    if(n-z+1 == 0){
                        continue;
                    }
                    if (arr[i][n - z+1]) {
                       
                        continue;
                    }
                    arr[i][n - z+1] = k;
              
                    k--;
                }
       
           
            }
        }
    }
    
    int x = 0;
    int y = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cout << arr[i][j] << ' ';
            if(arr[i][j] == num){
                x = i;
                y = j;
            }
           
        }
        cout << '\n';
    }
    cout << x << ' ' << y;


  
}
