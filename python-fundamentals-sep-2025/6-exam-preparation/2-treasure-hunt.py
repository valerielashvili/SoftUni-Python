treasure_chest = input().split('|')
tokens = input().split()
command = tokens[0]

while command != 'Yohoho!':
    if command == 'Loot':
        loot_items = [l for l in tokens[1:] if l not in treasure_chest]
        
        for loot in loot_items:
            treasure_chest.insert(0, loot)
    
    elif command == 'Drop':
        index = int(tokens[1])

        if 0 <= index <= len(treasure_chest):
            treasure_chest.append(treasure_chest.pop(index))

    elif command == 'Steal':
        count = int(tokens[1])
        stolen_items = treasure_chest[-count:]
        treasure_chest = treasure_chest[:-count]
        print(", ".join(stolen_items))

    tokens = input().split()
    command = tokens[0]

if len(treasure_chest) != 0:
    average_treasure_gain = sum(len(x) for x in treasure_chest) / len(treasure_chest)
    print(f"Average treasure gain: {average_treasure_gain:.2f} pirate credits.")
else:
    print("Failed treasure hunt.")
