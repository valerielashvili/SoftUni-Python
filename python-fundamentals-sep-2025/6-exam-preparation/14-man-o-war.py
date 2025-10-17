pirate_ship = [int(x) for x in input().split('>')]
warship = [int(x) for x in input().split('>')]
max_health = int(input())

while True:
    tokens = input().split()
    command = tokens[0]

    if command == 'Retire':
        break

    if command == 'Fire':
        i, damage = int(tokens[1]), int(tokens[2])

        if 0 <= i < len(warship):
            warship[i] -= damage

            if warship[i] <= 0:
                print("You won! The enemy ship has sunken.")
                break

    elif command == 'Defend':
        start_i, end_i, damage = int(tokens[1]), int(tokens[2]), int(tokens[3])
        sunk = False

        if 0 <= start_i < len(pirate_ship) and 0 <= end_i < len(pirate_ship):
            for idx in range(start_i, end_i + 1):
                pirate_ship[idx] -= damage

                if pirate_ship[idx] <= 0:
                    print("You lost! The pirate ship has sunken.")
                    sunk = True
                    break
        if sunk:
            break

    elif command == 'Repair':
        i, health = int(tokens[1]), int(tokens[2])

        if 0 <= i < len(pirate_ship):
            if pirate_ship[i] + health <= max_health:
                pirate_ship[i] += health
            else:
                pirate_ship[i] = max_health

    elif command == 'Status':
        repair_limit = max_health * 0.2
        sections_req_repair = sum(1 for x in pirate_ship if x < repair_limit)
        print(f"{sections_req_repair} sections need repair.")

if all(x > 0 for x in pirate_ship) and all(x > 0 for x in warship):
    print(f"Pirate ship status: {sum(s for s in pirate_ship)}\n"
          f"Warship status: {sum(s for s in warship)}")
