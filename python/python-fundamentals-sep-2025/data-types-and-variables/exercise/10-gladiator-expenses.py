lost_fights_count = int(input())
helmet_price = float(input())
sword_price = float(input())
shield_price = float(input())
armor_price = float(input())

trashed_helmet = 0
trashed_sword = 0
trashed_shield = 0
trashed_armor = 0

for i in range(1, lost_fights_count + 1):
    if i % 2 == 0:
        trashed_helmet += 1

    if i % 3 == 0:
        trashed_sword += 1

    if i % 6 == 0:
        trashed_shield += 1

    if i % 12 == 0:
        trashed_armor += 1

expenses = (trashed_helmet * helmet_price + trashed_sword * sword_price +
            trashed_shield * shield_price + trashed_armor * armor_price)

print(f"Gladiator expenses: {expenses:.2f} aureus")