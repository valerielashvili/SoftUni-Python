elements = input().split()
move = 1

while True:
    input_str = input()
    if input_str == "end":
        break

    tokens = input_str.split()
    idx_1 = int(tokens[0])
    idx_2 = int(tokens[1])

    out_of_bound = not (0 <= idx_1 < len(elements) and 0 <= idx_2 < len(elements))

    if idx_1 == idx_2 or out_of_bound:
        mid_idx = len(elements) // 2
        penalty_element = f"-{move}a"
        elements.insert(mid_idx, penalty_element)
        elements.insert(mid_idx, penalty_element)
        print("Invalid input! Adding additional elements to the board")

    else:
        if elements[idx_1] == elements[idx_2]:
            print(f"Congrats! You have found matching elements - {elements[idx_1]}!")
            higher = max(idx_1, idx_2)
            lower = min(idx_1, idx_2)
            elements.pop(higher)
            elements.pop(lower)
        else:
            print("Try again!")

    if len(elements) == 0:
            print(f"You have won in {move} turns!")
            break

    move += 1

if len(elements) > 0:
    print("Sorry you lose :(")
    print(" ".join(e for e in elements))
