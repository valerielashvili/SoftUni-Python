from collections import deque

rows, cols = [int(n) for n in input().split()]
snake = deque(s for s in input())
matrix = [['' for _ in range(cols)] for _ in range(rows)]

for row in range(rows):
    for col in range(cols):
        if row % 2 == 0:
            matrix[row][col] = snake[0]
        else:
            matrix[row][cols - col - 1] = snake[0]

        snake.append(snake.popleft())

for r in range(rows):
    print(f"{''.join(matrix[r])}")
