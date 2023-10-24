# https://www.acmicpc.net/problem/10989
# 메모리 제한이 있는 문제이다

# First Trial
# 단순 정렬 하는 문제인 줄 알고 그냥 풀어버림!
# 당연히 안돼....
# 메모리 초과

# ============================================
N = int(input())
li = [int(input()) for _ in range(N)]

for i in sorted(li):
    print(i)
# ============================================

# 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
# 이걸 이해를 못했음...

# Second Trial
# N이 10,000,000까지 주어진다며.....
# 시간 초과

# ============================================
N = int(input())

MAX_N = min(N, 10_000_000)
num_list = [0] * MAX_N

for i in range(N):
    num_list[int(input())] += 1

for i in range(MAX_N):
    if num_list[i] != 0:
        for _ in range(num_list[i]):
            print(i)
# ============================================


# Final Solution
# 억까야 이건.
# sys.stdin 을 사용하면 조금 더 시간을 절약 할 수 있나봄.
# ==========================================
import sys

n = int(sys.stdin.readline())
num_list = [0] * 10001

for _ in range(n):
    num_list[int(sys.stdin.readline())] += 1

for i in range(10001):
    if num_list[i] != 0:
        for j in range(num_list[i]):
            print(i)

# ==========================================
