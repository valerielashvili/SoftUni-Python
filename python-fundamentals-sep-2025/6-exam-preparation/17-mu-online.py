health = 100
bitcoins = 0
dungeon = input().split('|')
dungeon_passed = True

for room in dungeon:
    cmd, value = room.split(' ')

    if cmd == 'potion':
        potion = int(value)
        if health + potion > 100:
            potion = 100 - health
        health += potion
        print(f"You healed for {potion} hp.\n"
              f"Current health: {health} hp.")

    elif cmd == 'chest':
        coins = int(value)
        bitcoins += coins
        print(f"You found {coins} bitcoins.")

    else:
        damage, monster = int(value), cmd
        health -= damage
        if health > 0:
            print(f"You slayed {monster}.")
        else:
            print(f"You died! Killed by {monster}.\n"
                  f"Best room: {dungeon.index(room) + 1}")
            dungeon_passed = False
            break

if dungeon_passed:
    print(f"You've made it!\n"
          f"Bitcoins: {bitcoins}\n"
          f"Health: {health}")
