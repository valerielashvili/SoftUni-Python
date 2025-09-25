decorations_quantity = int(input())
days_until_christmas = int(input())

ornament_set_price = 2
tree_skirt_price = 5
tree_garland_price = 3
tree_lights_price = 15

christmas_spirit = 0
total_cost = 0

for day in range(1, days_until_christmas + 1):
    if day % 11 == 0:
        decorations_quantity += 2

    if day % 2 == 0:
        christmas_spirit += 5
        total_cost += ornament_set_price * decorations_quantity

    if day % 3 == 0:
        christmas_spirit += 13
        total_cost += (tree_skirt_price + tree_garland_price) * decorations_quantity

    if day % 5 == 0:
        christmas_spirit += 17
        total_cost += tree_lights_price * decorations_quantity

    if day % 10 == 0:
        christmas_spirit -= 20
        total_cost += tree_skirt_price + tree_garland_price + tree_lights_price

    if day % 15 == 0:
        christmas_spirit += 30

if days_until_christmas % 10 == 0:
    christmas_spirit -= 30

print(f"Total cost: {total_cost}\n"
      f"Total spirit: {christmas_spirit}")