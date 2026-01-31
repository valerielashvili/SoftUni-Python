numbers_list = [int(x) for x in input().split(", ")]
result = 1

for i in range(len(numbers_list)):
    number = numbers_list[i]
    if number <= 5:
        result *= number
    elif 5 < number <= 10:
        result /= number

# The input '1, 4, 5' doesn't give '20.0' as a result,
# so wasn't sure if I have format to the second decimal point.
print(result)
