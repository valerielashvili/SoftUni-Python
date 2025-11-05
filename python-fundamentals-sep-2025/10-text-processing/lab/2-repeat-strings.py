strings = input().split()
output = ''.join(x * len(x) for x in strings)
print(output)
