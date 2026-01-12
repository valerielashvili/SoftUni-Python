nums = (map(float, input().split()))

number_cnt = {}
for num in nums:
    if num not in number_cnt:
        number_cnt[num] = 0
    number_cnt[num] += 1

[print(f"{num:.1f} - {cnt} times") for num, cnt in number_cnt.items()]
