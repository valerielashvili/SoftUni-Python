events = input().split('|')

energy = 100
coins = 100
bakery_rush_over = False

for event in events:
    event = event.split('-')
    token = event[0]

    if token == 'rest':
        current_energy = int(event[1])

        if energy + current_energy > 100:
            current_energy = 100 - energy

        energy += current_energy
        print(f"You gained {current_energy} energy.\n"
              f"Current energy: {energy}.")

    elif token == 'order':
        coins_earned = int(event[1])

        if energy >= 30:
            coins += coins_earned
            energy -= 30
            print(f"You earned {coins_earned} coins.")
        else:
            energy += 50
            print("You had to rest!")
            continue

    else:
        coins_spent = int(event[1])

        if coins >= coins_spent:
            coins -= coins_spent
            print(f"You bought {token}.")
        else:
            bakery_rush_over = True
            print(f"Closed! Cannot afford {token}.")
            break

if not bakery_rush_over:
    print(f"Day completed!\n"
          f"Coins: {coins}\n"
          f"Energy: {energy}")
