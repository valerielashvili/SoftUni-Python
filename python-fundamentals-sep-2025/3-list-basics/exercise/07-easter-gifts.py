gifts = input().split()
command_str = ''

while command_str != 'No Money':
    command_str = input()
    commands = command_str.split()
    command = commands[0]
    gift = commands[1]

    if command == 'OutOfStock' and gift in gifts:
        gift_index = gifts.index(gift)
        gifts = ['None' if x == gift else x for x in gifts]

    elif command == 'Required':
        gift_index = int(commands[2])
        if 0 <= gift_index < len(gifts):
            gifts[gift_index] = gift

    elif command == 'JustInCase':
        gifts[-1] = gift

[print(g, end=' ') if g != 'None' else g for g in gifts]
