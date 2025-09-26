factor = int(input())
count = int(input())

multiples = []
i = factor

while len(multiples) != count:
    if i % factor == 0:
        multiples.append(i)
    i += 1

print(multiples)
