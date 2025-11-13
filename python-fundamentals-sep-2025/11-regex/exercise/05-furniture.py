import re

furniture = []
total_cost = 0.0
pattern = re.compile(
    r'^>>(?P<article>[A-Za-z]+)<<'
    r'(?P<price>(0|[1-9]\d*)(\.\d+)?)!'
    r'(?P<qnty>(0|[1-9]\d*))$'
)

while (line := input()) != "Purchase":
    match = pattern.match(line)
    if match:
        furniture.append(match.group('article'))
        total_cost += float(match.group('price')) * int(match.group('qnty'))

print("Bought furniture:")
if furniture:
    print(*furniture, sep="\n")
print(f"Total money spend: {total_cost:.2f}")
