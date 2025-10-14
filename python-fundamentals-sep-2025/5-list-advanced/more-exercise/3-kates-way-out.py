# This solution uses Depth-First Search algorithm

# An exit is any open space on the maze boundary
def is_exit(r, c, rows, cols):
    return (r == 0 or r == rows - 1 or c == 0 or c == cols - 1)

# Explore open cells in the maze using recursion
def find_way_out(row, col, grid, visited):
    rows = len(grid)
    cols = len(grid[0])

    # Mark current cell as visited
    visited.add((row, col))

    # Check if current cell is an exit
    found_exit = is_exit(row, col, rows, cols)
    max_move = 0

    # Explore neighbour cells in 4 directions
    for d_row, d_col in [(-1,0), (1,0), (0,-1), (0,1)]:
        new_r, new_c = row + d_row, col + d_col

        # Check boundaries, not visited, and not a wall
        if (0 <= new_r < rows and 0 <= new_c < cols and 
            (new_r, new_c) not in visited and grid[new_r][new_c] == ' '):

            exit_found, move = find_way_out(new_r, new_c, grid, visited)

            if exit_found:
                found_exit = True
                if move > max_move:
                    max_move = move
    
    visited.remove((row, col))

    # Return length including current cell
    return found_exit, max_move + 1

# Input
n_rows = int(input())
maze = []
wall = False

for _ in range(n_rows):
    maze.append(input())

# Find Kate's starting position
for i, row in enumerate(maze):
    if 'k' in row:
        start_row, start_col = i, row.index('k')
        break

visited_cells = set()
exit_found, move_count = find_way_out(start_row, start_col, maze, visited_cells)

# Output
if exit_found:
    print(f"Kate got out in {move_count} moves")
else:
    print("Kate cannot get out")
