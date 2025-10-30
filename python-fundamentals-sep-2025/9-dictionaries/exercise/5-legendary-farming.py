from typing import Tuple

def handle_legendary(curr_item: str, leg_items: dict) -> Tuple[dict, bool, str]:
    leg_items[curr_item] -= 250
    leg_obt = True
    leg_item = ""

    if curr_item == 'shards':
        leg_item = 'Shadowmourne'
    elif curr_item == 'fragments':
        leg_item = 'Valanyr'
    elif curr_item == 'motes':
        leg_item = 'Dragonwrath'

    prnt_result = f"{leg_item} obtained!"
    return leg_items, leg_obt, prnt_result

legendary = {'shards': 0, 'fragments': 0, 'motes': 0}
junk = {}
leg_obtained = False

while not leg_obtained:
    items = input().split()

    for i in range(0, len(items), 2):
        qty, item = int(items[i]), items[i + 1].lower()

        if item in legendary:
            legendary[item] += qty

            if legendary[item] >= 250:
                legendary, leg_obtained, result = handle_legendary(item, legendary)
                print(result)
                break
        else:
            current_qty = junk.get(item, 0)
            junk[item] = current_qty + qty

for l, q in legendary.items():
    print(f"{l}: {q}")

for j, q in junk.items():
    print(f"{j}: {q}")
