import sys

biggest = -sys.maxsize
total = 0

n = int(input())

for i in range(0, n):
    num = int(input())
    total += num

    if num > biggest:
        biggest = num

total -= biggest
if biggest == total:
    print(f"Yes\n"
          f"Sum = {biggest}")
else:
    print(f"No\n"
          f"Diff = {abs(total - biggest)}")
