num = int(input())
heroes = {}

for n in range(num):
    name, hp, mp = [int(x) if x.isdigit() else x for x in input().split(' ')]
    hp = 100 if hp > 100 else hp
    mp = 200 if mp > 200 else mp
    if name not in heroes:
        heroes[name] = {'hp': hp, 'mp': mp}

while (tokens := input()) != 'End':
    tokens = tokens.split(' - ')
    command = tokens[0]

    if command == 'CastSpell':
        name, mp_needed, spell = tokens[1], int(tokens[2]), tokens[3]
        if heroes[name]['mp'] >= mp_needed:
            heroes[name]['mp'] -= mp_needed
            print(f"{name} has successfully cast {spell} and now has {heroes[name]['mp']} MP!")
        else:
            print(f"{name} does not have enough MP to cast {spell}!")

    elif command == 'TakeDamage':
        name, damage, attacker = tokens[1], int(tokens[2]), tokens[3]
        heroes[name]['hp'] -= damage
        if heroes[name]['hp'] > 0:
            print(f"{name} was hit for {damage} HP by {attacker} and now has {heroes[name]['hp']} HP left!")
        else:
            print(f"{name} has been killed by {attacker}!")

    elif command == 'Recharge':
        name, amount = tokens[1], int(tokens[2])
        if heroes[name]['mp'] + amount > 200:
            amount = 200 - heroes[name]['mp']
        heroes[name]['mp'] += amount
        print(f"{name} recharged for {amount} MP!")

    elif command == 'Heal':
        name, amount = tokens[1], int(tokens[2])
        if heroes[name]['hp'] + amount > 100:
            amount = 100 - heroes[name]['hp']
        heroes[name]['hp'] += amount
        print(f"{name} healed for {amount} HP!")

for name, stats in heroes.items():
    if stats['hp'] > 0:
        print(f"{name}\n  HP: {stats['hp']}\n  MP: {stats['mp']}")
