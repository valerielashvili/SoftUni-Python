import math

group_size = int(input())
days = int(input())

money_earned = 0
money_spent = 0

for i in range(1, days + 1):
    if i % 10 == 0:
        group_size -= 2

    if i % 15 == 0:
        group_size += 5
        money_spent += 2 * group_size

    if i % 3 == 0:
        money_spent += 3 * group_size

    if i % 5 == 0:
        money_earned += 20 * group_size
    
    money_earned += 50
    money_spent += 2 * group_size

money_earned -= money_spent
companion_earned = math.floor(money_earned / group_size)

print(f"{group_size} companions received {companion_earned} coins each.")