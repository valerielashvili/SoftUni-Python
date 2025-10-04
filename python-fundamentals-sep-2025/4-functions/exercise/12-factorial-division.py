first_num = int(input())
second_num = int(input())

def divide_factorials(a, b):
    for i in range(1, a):
        a *= i
    for j in range(1, b):
        b *= j
    return f"{a / b:.2f}"

result = divide_factorials(first_num, second_num)
print(result)
