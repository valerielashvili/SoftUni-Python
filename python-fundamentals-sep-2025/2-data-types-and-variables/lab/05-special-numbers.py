num = int(input())

for i in range(1, num + 1):
    ones = i % 10
    tens = i // 10
    sum_of_digits = ones + tens

    if sum_of_digits == 5 or sum_of_digits == 7 or sum_of_digits == 11:
        print(f"{i} -> True")
    else:
        print(f"{i} -> False")