number = int(input())

def check_perfect_num(num):
    perfect_num = 0
    for n in range(1, num - 1):
        if num % n == 0:
            perfect_num += n

    if perfect_num == num:
        return "We have a perfect number!"
    else:
        return "It's not so perfect."

output = check_perfect_num(number)
print(output)
