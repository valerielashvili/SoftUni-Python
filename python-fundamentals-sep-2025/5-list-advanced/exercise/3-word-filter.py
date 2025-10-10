text = [x if len(x) % 2 == 0 else None for x in input().split(' ')]
text = list(filter(lambda x: x is not None, text))

for i in text: print(i)
