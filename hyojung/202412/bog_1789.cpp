#include <iostream>
#include <cmath>
using namespace std;
int main(void){
    long long s;
    cin >> s;
    long long count = 1;
    long long start = 1;
    while(true){
        if(start >= s){
            if(start == s){
                cout << count;
                break;
            }
            else{
                s -= start;
                count--;
                cout << count;
                break;
            }
        }
        count++;
        start += count; 
   
    }
}