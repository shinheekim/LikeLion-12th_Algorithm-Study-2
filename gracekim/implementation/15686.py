# 15686 치킨 배달 / Gold 5 

import sys 
from itertools import combinations
input = sys.stdin.readline

n, m = map(int, input().split())
city = []

for _ in range(n):
  city.append(list(map(int, input().split())))
  
result = 9999
house = [] # 집의 좌표
chicken = [] # 치킨집의 좌표

for i in range(n):
  for j in range(n):
    if city[i][j] == 1:
      house.append([i, j])
    elif city[i][j] == 2:
      chicken.append([i, j])
      

for c in combinations(chicken, m): # m개의 치킨집
  temp = 0
  for h in house:
    c_len = 9999
    for j in range(m):
      c_len = min(c_len, abs(h[0] - c[j][0]) + abs(h[1] - c[j][1])) # 치킨거리
    temp += c_len
  result = min(result, temp)
  
print(result)