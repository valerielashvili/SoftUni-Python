# Using Bubble sort
num = int(input())
num_to_str = str(num)

# Sorted largest_list represents the largest number formed from the digis of the num
largest_list = [int(i) for i in num_to_str]
largest_len = len(largest_list)

for i in range(largest_len):
    for j in range(largest_len - 2, -1, -1):
        if largest_list[j] < largest_list[j + 1]:
            largest_list[j], largest_list[j + 1] = largest_list[j + 1], largest_list[j]

for k in largest_list:
    print(f"{k}", end="")