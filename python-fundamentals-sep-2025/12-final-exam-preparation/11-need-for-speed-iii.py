num = int(input())
cars = {}

for n in range(num):
    tokens = input().split('|')
    car, mileage, fuel = tokens[0], int(tokens[1]), int(tokens[2])
    cars[car] = {'mileage': mileage, 'fuel': fuel}

while (cmd_tokens := input()) != 'Stop':
    cmd_tokens = cmd_tokens.split(' : ')
    cmd = cmd_tokens[0]

    if cmd == 'Drive':
        car, distance, fuel = cmd_tokens[1], int(cmd_tokens[2]), int(cmd_tokens[3])
        if cars[car]['fuel'] < fuel:
            print("Not enough fuel to make that ride")
        else:
            cars[car]['mileage'] += distance
            cars[car]['fuel'] -= fuel
            print(f"{car} driven for {distance} kilometers. {fuel} liters of fuel consumed.")

        if cars[car]['mileage'] >= 100000:
            del cars[car]
            print(f"Time to sell the {car}!")

    elif cmd == 'Refuel':
        car, fuel = cmd_tokens[1], int(cmd_tokens[2])
        diff = 75 - cars[car]['fuel']
        if fuel > diff:
            fuel = diff
            cars[car]['fuel'] += fuel
        else:
            cars[car]['fuel'] += fuel
        print(f"{car} refueled with {fuel} liters")

    elif cmd == 'Revert':
        car, kilometers = cmd_tokens[1], int(cmd_tokens[2])
        cars[car]['mileage'] -= kilometers
        if cars[car]['mileage'] < 10000:
            cars[car]['mileage'] = 10000
        else:
            print(f"{car} mileage decreased by {kilometers} kilometers")

for car, stats in cars.items():
    print(f"{car} -> Mileage: {stats['mileage']} kms, Fuel in the tank: {stats['fuel']} lt.")
