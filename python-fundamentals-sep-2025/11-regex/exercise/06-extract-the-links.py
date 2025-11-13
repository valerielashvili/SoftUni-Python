import re

lines = []
while True:
    line = input()
    if not line:
        break
    lines.append(line)

pattern = re.compile(r'w{3}\.[A-Za-z0-9-]+(?:\.[a-z]+)+')

for string in lines:
    match = pattern.search(string)
    if match:
        print(match.group())
