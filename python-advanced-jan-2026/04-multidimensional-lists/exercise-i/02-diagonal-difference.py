size = int(input())
matrix = []
primary_diagonal = []
secondary_diagonal = []

for row in range(size):
    matrix.append([int(n) for n in input().split()])

for row in range(size):
        primary_diagonal.append(matrix[row][row])
        secondary_diagonal.append(matrix[row][size - row - 1])

prime_diag_sum = sum(primary_diagonal)
sec_diag_sum = sum(secondary_diagonal)

print(abs(prime_diag_sum - sec_diag_sum))
