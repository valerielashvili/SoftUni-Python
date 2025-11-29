cities = {}

while (tokens := input()) != 'Sail':
    tokens = tokens.split('||')
    city, population, gold = tokens[0], int(tokens[1]), int(tokens[2])

    if city not in cities:
        cities[city] = {'population': population, 'gold': gold}
    else:
        cities[city]['population'] += population
        cities[city]['gold'] += gold

while (events := input()) != 'End':
    events = events.split('=>')
    cmd = events[0]

    if cmd == 'Plunder':
        city, people, gold = events[1], int(events[2]), int(events[3])
        cities[city]['population'] -= people
        cities[city]['gold'] -= gold
        print(f"{city} plundered! {gold} gold stolen, {people} citizens killed.")

        if cities[city]['population'] <= 0 or cities[city]['gold'] <= 0:
            del cities[city]
            print(f"{city} has been wiped off the map!")

    elif cmd == 'Prosper':
        city, gold = events[1], int(events[2])
        if gold < 0:
            print(f"Gold added cannot be a negative number!")
        else:
            cities[city]['gold'] += gold
            print(f"{gold} gold added to the city treasury. {city} now has {cities[city]['gold']} gold.")

if cities:
    print(f"Ahoy, Captain! There are {len(cities)} wealthy settlements to go to:")
    for city, stats in cities.items():
        print(f"{city} -> Population: {stats['population']} citizens, Gold: {stats['gold']} kg")
else:
    print(f"Ahoy, Captain! All targets have been plundered and destroyed!")
