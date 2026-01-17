n = int(input())
matrix = []

for row in range(n):
    matrix.append([c for c in input()])

symbol = input()
found = False

for row in range(n):
    if symbol in matrix[row]:
        print(f'({row}, {matrix[row].index(symbol)})')
        found = True
        break

if not found:
    print(f'{symbol} does not occur in the matrix')
