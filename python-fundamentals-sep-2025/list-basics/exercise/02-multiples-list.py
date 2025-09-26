factor = int(input()) * -1
count = int(input()) * -1

multiples = []

if factor > 1:
    multiples.append(factor)

for i in range(factor, count + 1):
    multiples.append(i * factor)

print(multiples)
