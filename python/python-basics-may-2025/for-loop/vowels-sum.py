text = input()

total = 0

for char in text:
    if char == 'a':
        total += 1
    elif char == 'e':
        total += 2
    elif char == 'i':
        total += 3
    elif char == 'o':
        total += 4
    elif char == 'u':
        total += 5

print(total)
