tokens = input().split('||')
fuel = int(input())
ammunition = int(input())

for token in tokens:
    token = token.split()
    command = token[0]

    if command == 'Titan':
        print("You have reached Titan, all passengers are safe.")
        break

    elif command == 'Travel':
        light_years = int(token[1])
        fuel -= light_years

        if fuel >= 0:
            print(f"The spaceship travelled {light_years} light-years.")
        else:
            print("Mission failed.")
            break

    elif command == 'Enemy':
        enemy_armour = int(token[1])

        if ammunition >= enemy_armour:
            ammunition -= enemy_armour
            print(f"An enemy with {enemy_armour} armour is defeated.")
        else:
            fuel -= enemy_armour * 2

            if fuel > 0:
                print(f"An enemy with {enemy_armour} armour is outmaneuvered.")
            else:
                print("Mission failed.")
                break

    elif command == 'Repair':
        resources = int(token[1])
        fuel_added, ammo_added = resources, resources * 2
        fuel += fuel_added
        ammunition += ammo_added

        print(f"Ammunitions added: {ammo_added}.\n"
              f"Fuel added: {fuel_added}.")
