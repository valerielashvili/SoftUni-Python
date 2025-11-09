string = input()
strings = []
substr, digit, result = '', '', ''

for i in range(len(string)):
    if not string[i].isdigit():
       substr += string[i]
    else:
        digit += string[i]

        if i + 1 <= len(string) - 1:
            if string[i + 1].isdigit():
                digit += string[i + 1]

        strings.append(substr)
        strings.append(int(digit))
        substr, digit = '', ''

for i in range(0, len(strings), 2):
    result += strings[i].upper() * strings[i + 1]

print(f"Unique symbols used: {len(set(result))}")
print(result)
