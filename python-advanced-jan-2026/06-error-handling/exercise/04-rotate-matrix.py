class MatrixContentError(Exception):
    """This is a custom exception for noninteger matrix."""
    pass


class MatrixSizeError(Exception):
    """This is a custom exception for matrix N x N size."""
    pass


def rotate_matrix(matrix):
    matrix_length = len(matrix)

    # Verify the matrix size is N x N
    if not all(len(r) == matrix_length for r in matrix):
        raise MatrixSizeError('The size of the matrix is not a perfect square')

    for i in range(matrix_length):
        for j in range(i, matrix_length):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

    for i in range(matrix_length):
        matrix[i].reverse()


mtrx = []

while True:
    line = input().split()

    # Verify the matrix contains only integers
    if not all(x.isdigit() for x in line):
        raise MatrixContentError('The matrix must consist of only integers')
    else:
        line = [int(x) for x in line]


    if not line:
        break
    mtrx.append(line)

rotate_matrix(mtrx)

for row in mtrx:
    print(*row, sep=' ')
