import re

num = int(input())
plants = {}
delimit = re.compile(r': | - ')

for n in range(num):
    plant, rarity = input().split('<->')
    plants[plant] = {'rarity': rarity, 'rating': []}

while (line := input()) != 'Exhibition':
    tokens = delimit.split(line)
    cmd = tokens[0]

    if cmd == 'Rate':
        plant, rating = tokens[1], int(tokens[2])
        if plant in plants:
            plants[plant]['rating'].append(rating)
        else:
            print('error')

    elif cmd == 'Update':
        plant, new_rarity = tokens[1], tokens[2]
        if plant in plants:
            plants[plant]['rarity'] = new_rarity
        else:
            print('error')

    elif cmd == 'Reset':
        plant = tokens[1]
        if plant in plants:
            plants[plant]['rating'] = []
        else:
            print('error')

print("Plants for the exhibition:")
for plant, stats in plants.items():
    if stats['rating']:
        avg_rating = sum(stats['rating']) / len(stats['rating'])
    else:
        avg_rating = 0.0
    print(f"- {plant}; Rarity: {stats['rarity']}; Rating: {avg_rating:.2f}")
