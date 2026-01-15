from collections import deque


chocolates = deque(int(c) for c in input().split(', '))
cups_of_milk = deque(int(m) for m in input().split(', '))
milkshakes = 0

while chocolates and cups_of_milk:
    choco = chocolates.pop()
    milk = cups_of_milk.popleft()

    if choco <= 0 and milk <= 0:
        continue

    if choco <= 0:
        cups_of_milk.appendleft(milk)
        continue

    if milk <= 0:
        chocolates.append(choco)
        continue

    if choco == milk:
        milkshakes += 1
    else:
        cups_of_milk.append(milk)
        chocolates.append(choco - 5)

    if milkshakes == 5:
        break

if milkshakes == 5:
    print('Great! You made all the chocolate milkshakes needed!')
else:
    print('Not enough milkshakes.')

if chocolates:
    print(f"Chocolate: {', '.join(map(str, chocolates))}")
else:
    print(f'Chocolate: empty')

if cups_of_milk:
    print(f"Milk: {', '.join(map(str, cups_of_milk))}")
else:
    print(f'Milk: empty')
