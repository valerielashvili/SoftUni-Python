budget = float(input())
flour_kg_price = float(input())

eggs_pack_price = flour_kg_price * 0.75
milk_litre_price = flour_kg_price + flour_kg_price * 0.25

loaf_price = eggs_pack_price + flour_kg_price + milk_litre_price / 4
loves_total = int(budget // loaf_price)
budget_left = budget - loaf_price * loves_total

colored_eggs = loves_total * 3
for i in range(1, loves_total - 1, +3):
    colored_eggs -= i

print(f"You made {loves_total} loaves of Easter bread! "
      f"Now you have {colored_eggs} eggs and {budget_left:.2f}BGN left.")