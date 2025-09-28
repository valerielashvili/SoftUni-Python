import sys

list_of_nums = input().split()
num = int(input())
list_of_ints = [int(x) for x in list_of_nums]

smallest = sys.maxsize

for i in range(num):
    for j in list_of_ints:
        if j < smallest:
            smallest = j

    list_of_ints.remove(smallest)
    smallest = sys.maxsize

print(*list_of_ints, sep=', ')
