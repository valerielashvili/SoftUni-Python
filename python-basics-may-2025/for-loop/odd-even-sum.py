n = int(input())

even_sum = 0
odd_sum = 0

for i in range(0, n):
    num = int(input())

    if i % 2 == 0:
        even_sum += num
    else:
        odd_sum += num

if even_sum == odd_sum:
    print(f"Yes\n"
          f"Sum = {even_sum}")
else:
    print(f"No\n"
          f"Diff = {abs(even_sum - odd_sum)}")
