rows = int(input().split(', ')[0])
matrix = []
elements_sum = 0

for row in range(rows):
    lines = [int(x) for x in input().split(", ")]
    matrix.append(lines)
    elements_sum += sum(lines)

print(elements_sum)
print(matrix)
