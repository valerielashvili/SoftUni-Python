text = input()
output = ''

for i in range(len(text) - 1):
    if text[i] == text[i + 1]:
        continue
    else:
        output += text[i]

output += text[-1]
print(output)
