animals_str = input()
animals = animals_str.split(", ")
animals_len = len(animals)

for i in range(animals_len):
    if i == animals_len - 1 and animals[i] == 'wolf':
        print("Please go away and stop eating my sheep")
    elif animals[i] == 'wolf':
        threatened_sheep = animals_len - (i + 1)
        print(f"Oi! Sheep number {threatened_sheep}! You are about to be eaten by a wolf!")