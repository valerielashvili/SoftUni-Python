n_lines = int(input())
numbers = []
filtered = []

for i in range(n_lines):
    num = int(input())
    numbers.append(num)

command = input()

if command == 'even':
    for n in numbers:
        if n % 2 == 0:
            filtered.append(n)
elif command == 'odd':
    for n in numbers:
        if n % 2 != 0:
            filtered.append(n)
elif command == 'negative':
    for n in numbers:
        if n < 0:
            filtered.append(n)
elif command == 'positive':
    for n in numbers:
        if n >= 0:
            filtered.append(n)

print(filtered)
