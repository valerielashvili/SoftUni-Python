first_num = int(input())
second_num = int(input())
third_num = int(input())

def add_and_subtract(a, b, c):

    def sum_numbers(d, e):
        return d + e

    def subtract(f, g):
        return f - g

    sum_result = sum_numbers(a, b)
    return subtract(sum_result, c)

result = add_and_subtract(first_num, second_num, third_num)
print(result)
