x = int(input())
y = int(input())
magic_num = int(input())

combinations_count = 0
magic_num_found = False

for i in range(x, y + 1):
    if magic_num_found:
        break

    for j in range(x, y + 1):
        combinations_count += 1
        if i + j == magic_num:
            magic_num_found = True
            print(f"Combination N:{combinations_count} ({i} + {j} = {magic_num})")
            break

if not magic_num_found:
    print(f"{combinations_count} combinations - neither equals {magic_num}")