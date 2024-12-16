# 1448 삼각형 만들기 / Silver 3

import sys 
input = sys.stdin.readline

n = int(input())

triangle = []
for _ in range(n):
  triangle.append(int(input()))
  
triangle.sort(reverse = True)

check = False

for i in range(0, n - 2):
  if triangle[i] < triangle[i+1] + triangle[i+2]:
    print(triangle[i] + triangle[i+1] + triangle[i+2])
    check = True
    
    break
  
if not check:
  print(-1)