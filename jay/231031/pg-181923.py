# https://school.programmers.co.kr/learn/courses/30/lessons/181923


def solution(arr, queries):
    ans = []
    answer = []

    for s, e, k in queries:
        res = []
        for i in range(s, e + 1):
            if k < arr[i]:
                res.append(arr[i])
        ans.append(res)

    for arr in ans:
        if not arr:
            answer.append(-1)
            continue
        answer.append(min(arr))

    return answer
