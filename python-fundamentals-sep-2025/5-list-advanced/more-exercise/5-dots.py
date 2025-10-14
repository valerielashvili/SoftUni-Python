def is_dot(r, c):
    return board[r][c] == '.'

def in_bounds(r, c):
    return 0 <= r < len(board) and 0 <= c < len(board[0])

def is_wall(r, c):
    return board[r][c] in "-–"

def is_visited(r, c):
    return board[r][c] == 'v'

def find_dots_dfs(r, c):
    if not in_bounds(r, c) or is_wall(r, c) or is_visited(r, c):
        return 0

    board[r][c] = 'v'
    dot_cnt = 1
    for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
        dot_cnt += find_dots_dfs(r + dr, c + dc)
    return dot_cnt

# Read input
n = int(input())
board = [input().split() for _ in range(n)]

dot_cnt_max = 0
for row in range(len(board)):
    for col in range(len(board[0])):
        if is_dot(row, col):
            dot_cnt_max = max(dot_cnt_max, find_dots_dfs(row, col))

print(dot_cnt_max)
