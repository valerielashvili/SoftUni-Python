size = int(input())
matrix = []
primary_diagonal = []
secondary_diagonal = []

for row in range(size):
    matrix.append([int(n) for n in input().split(', ')])

for row in range(size):
        primary_diagonal.append(matrix[row][row])
        secondary_diagonal.append(matrix[row][size - row - 1])

print(f"Primary diagonal: {', '.join(map(str, primary_diagonal))}. Sum: {sum(primary_diagonal)}")
print(f"Secondary diagonal: {', '.join(map(str, secondary_diagonal))}. Sum: {sum(secondary_diagonal)}")
