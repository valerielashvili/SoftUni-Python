n_lines = int(input())
odd_nums, even_nums = set(), set()

for i in range(n_lines):
    name, char_sum = input(), 0
    for char in name:
        char_sum += ord(char)

    char_sum //= i + 1

    if char_sum % 2 == 1:
        odd_nums.add(char_sum)
    else:
        even_nums.add(char_sum)

odd_nums_sum, even_nums_sum = sum(odd_nums), sum(even_nums)

if odd_nums_sum == even_nums_sum:
    print(f"{', '.join(map(str, odd_nums | even_nums))}")
elif odd_nums_sum > even_nums_sum:
    print(f"{', '.join(map(str, odd_nums - even_nums))}")
elif even_nums_sum > odd_nums_sum:
    print(f"{', '.join(map(str, odd_nums ^ even_nums))}")
