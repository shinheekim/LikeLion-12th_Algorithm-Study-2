# 2303 숫자 게임 / Silver 5

import sys 
input = sys.stdin.readline

n = int(input())
score = []

for _ in range(n):
  card = list(map(int,input().split()))
  max_digit = 0
  for i in range(5):
    for j in range(i + 1, 5):
      for m in range(j + 1, 5):
        digit = (card[i] + card[j] + card[m]) % 10
        if digit >= max_digit:
          max_digit = digit
  score.append(max_digit)

for i in range(n - 1, -1, -1):
  if score[i] == max(score):
    print(i + 1)
    break