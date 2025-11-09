string = input()
strength = 0
result = ''

for i in range(len(string)):
    if string[i] == '>':
        strength += int(string[i + 1])
        result += '>'
    elif strength > 0:
        strength -= 1
    else:
        result += string[i]

print(result)
