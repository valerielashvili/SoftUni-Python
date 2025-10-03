n_lines = int(input())
word = input()
strings = []

for i in range(n_lines):
    user_string = input()
    strings.append(user_string)

print(strings)

for j in range(len(strings) - 1, -1, -1):
    element = strings[j]
    if word not in element:
        strings.remove(element)

print(strings)
