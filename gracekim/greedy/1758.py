# 1758 알바생 강호 / Silver 4 

import sys 
input = sys.stdin.readline

n = int(input())
tips = [int(input()) for _ in range(n)]

tips = sorted(tips, reverse=True)
answer = 0

for i in range(n):
  tmp = tips[i] - i
  if tmp < 0:
    continue
  answer += tmp
  
print(answer)