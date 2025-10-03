first_num = int(input())
second_num = int(input())
third_num = int(input())

def smallest_num(a, b, c):
    smallest = a

    for n in b, c:
        if n < smallest:
            smallest = n

    return smallest

print(smallest_num(first_num, second_num, third_num))
