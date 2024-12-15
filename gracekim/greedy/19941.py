# 19941 햄버거 분배 / Silver 3

import sys 
input = sys.stdin.readline

n, k = map(int, input().split())
place = list(input())
result = 0

for i in range(n):
  if place[i] == 'P':
    for j in range(max(i - k, 0), min(i + k + 1, n)):
      if place[j] == 'H':
        place[j] = 0
        result += 1
        break
      
print(result)