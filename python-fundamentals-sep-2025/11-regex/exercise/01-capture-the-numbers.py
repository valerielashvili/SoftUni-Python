import re

lines = []
while True:
    line = input()
    if not line:
        break
    lines.append(line)

matches = []
for text in lines:
    matches.extend(re.findall(r'\d+', text))

print(' '.join(matches))
