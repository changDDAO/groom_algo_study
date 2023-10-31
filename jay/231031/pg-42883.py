# https://school.programmers.co.kr/learn/courses/30/lessons/42883


def solution(number, k):
    res = []

    if "".join(number) == "".join(sorted(number, reverse=True)):
        return "".join(number[: len(number) - k])

    for num in number:
        if not res:
            res.append(num)
            continue

        if k > 0:
            while res[-1] < num:
                res.pop()
                k -= 1

                if not res or k == 0:
                    break

        res.append(num)

    return "".join(res)
