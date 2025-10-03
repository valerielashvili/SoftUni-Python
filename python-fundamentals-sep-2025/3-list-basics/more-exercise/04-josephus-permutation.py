numbers = [int(n) for n in input().split()]
k = int(input()) - 1
i = k

executed = []

while len(numbers) != 0:
    if i >= len(numbers):
        while i >= len(numbers):
            i -= len(numbers)

    executed.append(numbers[i])
    del numbers[i]
    i += k

output = ','.join(str(n) for n in executed)
print(f"[{output}]")
