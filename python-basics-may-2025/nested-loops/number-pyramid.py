n = int(input())

counter = 1
out_of_range = False

for row in range(1, n + 1):
    for col in range(1, row + 1):

        print(f"{counter} ", end="")
        counter += 1
        if counter > n:
            out_of_range = True
            break
            
    if out_of_range:
        break
    print()