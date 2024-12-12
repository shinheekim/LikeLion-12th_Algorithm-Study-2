#include <iostream>
#include <string>
#include <set>
using namespace std;

int main(void){
    //모든 D에 대해 유일하면
    while(true){
        string str;
        cin >> str;
        if(str == "*"){
            break;
        }
        bool flag = false;
        for(int i = 1;i<str.size();i++){
            int start = 0;
            int end = start + i;
            set<string> s;
            while(true){
                if(end >= str.size() || start >= str.size()){
                    break;
                }
                string newStr = "";
                newStr += str[start];
                newStr += str[end];
                if(newStr.size() == 2){
                  if(s.count(newStr) != 0){
                 
                        flag = true;
                        break;
                    }
                    s.insert(newStr);
                }
                newStr = "";
                end++;
                start++;
                
            }
        }
        if(flag){
            cout << str << " is NOT surprising.\n";
        }
        else{
            cout << str << " is surprising.\n";
        }
    }
}
