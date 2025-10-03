list_of_ints = input().split(', ')
list_of_ints = [int(num) for num in list_of_ints]

non_zeros = [num for num in list_of_ints if num != 0]
zeros = [num for num in list_of_ints if num == 0]
list_of_ints = non_zeros + zeros

print(list_of_ints)
