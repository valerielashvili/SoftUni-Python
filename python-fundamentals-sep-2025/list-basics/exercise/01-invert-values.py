string_of_nums = input()
numbers = string_of_nums.split(" ")

for i in range(len(numbers)):
    numbers[i] = int(numbers[i])
    numbers[i] = -numbers[i]

print(numbers)
