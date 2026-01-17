rows = int(input())
matrix = []
primary_diagonal_sum = 0

for row in range(rows):
    matrix.append([int(n) for n in input().split(' ')])

for i in range(rows):
    for j in range(rows):
        primary_diagonal_sum += matrix[i][i]
        break

print(primary_diagonal_sum)
