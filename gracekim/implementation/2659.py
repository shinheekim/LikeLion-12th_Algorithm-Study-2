# 2659 십자카드 문제 / Silver 3 
from collections import deque

import sys 
input = sys.stdin.readline

find = deque(map(int, input().split()))

def solution(num):
  find = deque(num)
  clock = 10000
  for _ in range(4):
    now = find[0] * 1000 + find[1] * 100 + find[2] * 10 + find[3] * 1
    if now < clock:
      clock = now
    find.rotate(1)
  
  return clock
  
clock = solution(find)

answer = 0
start = 1111
while start <= clock:
  if solution(list(map(int, list(str(start))))) == start:
    answer += 1
    
  start += 1

print(answer)