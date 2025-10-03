numbers = [int(x) for x in input().split()]

even_nums = filter(lambda n: n % 2 == 0, numbers)
print(list(even_nums))
