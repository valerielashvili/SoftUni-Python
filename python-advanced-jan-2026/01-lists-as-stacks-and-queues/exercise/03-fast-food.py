from collections import deque


food_qnty = int(input())
orders = deque([int(o) for o in input().split()])

print(max(orders))

while orders:
    current_order = orders.popleft()
    if current_order <= food_qnty:
        food_qnty -= current_order
    else:
        orders.insert(0, current_order)
        break

if orders:
    print(f"Orders left: {' '.join(str(item) for item in orders)}")
else:
    print('Orders complete')
