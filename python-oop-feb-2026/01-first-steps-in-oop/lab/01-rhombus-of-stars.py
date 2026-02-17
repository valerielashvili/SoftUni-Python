def print_row(size, cnt):
    for row in range(size - cnt):
        print(" ", end="")
    for row in range(1, cnt):
        print("*", end=" ")
    print("*")


r_size = int(input())

for star_count in range(1, r_size):
    print_row(r_size, star_count)
for star_count in range(r_size, 0, -1):
    print_row(r_size, star_count)
