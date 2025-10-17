houses = [int(x) for x in input().split('@')]
input_str = input()
jump_idx = 0

while input_str != 'Love!':
    tokens = input_str.split()
    command = tokens[0]
    jump_idx += int(tokens[1])

    out_of_bound = not 0 <= jump_idx < len(houses)

    if out_of_bound:
        jump_idx = 0

    if command == 'Jump':
        if houses[jump_idx] - 2 >= 0:
            houses[jump_idx] -= 2

            if houses[jump_idx] == 0:
                print(f"Place {jump_idx} has Valentine's day.")
        elif houses[jump_idx] == 0:
            print(f"Place {jump_idx} already had Valentine's day.")

    input_str = input()

print(f"Cupid's last position was {jump_idx}.")

if all(x == 0 for x in houses):
    print("Mission was successful.")
else:
    print(f"Cupid has failed {sum(1 for h in houses if h > 0)} places.")
