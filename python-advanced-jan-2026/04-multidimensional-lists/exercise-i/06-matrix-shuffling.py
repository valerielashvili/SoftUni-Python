rows, cols = [int(x) for x in input().split()]
matrix = []

for row in range(rows):
    matrix.append([n for n in input().split()])

while (line := input()) != 'END':
    tokens = line.split()
    cmd = tokens[0]
    target_exists, target_is_valid = False, False

    if len(tokens[1:]) == 4:
        row1, col1, row2, col2 = (int(c) for c in tokens[1:])
        target_exists = True
        target_is_valid = 0 <= (row1 and row2) <= rows and 0 <= (col1 and col2) <= cols

    if cmd == 'swap' and target_exists and target_is_valid:
        tmp_value = matrix[row1][col1]
        matrix[row1][col1] = matrix[row2][col2]
        matrix[row2][col2] = tmp_value

        for row in matrix:
            print(*row)
    else:
        print("Invalid input!")
