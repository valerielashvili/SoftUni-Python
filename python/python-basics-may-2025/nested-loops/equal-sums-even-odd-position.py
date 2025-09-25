x = int(input())
y = int(input())

for num in range(x, y + 1):
    num_to_str = str(num)
    even_index_sum = 0
    odd_index_sum = 0

    for index, digit in enumerate(num_to_str):
        if index % 2 == 0:
            even_index_sum += int(digit)
        else:
            odd_index_sum += int(digit)

    if even_index_sum == odd_index_sum:
        print(num, end=' ')