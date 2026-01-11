from collections import deque


bullet_price = int(input())
barrel_size = int(input())
bullets = deque([int(b) for b in input().split()])
locks = deque([int(l) for l in input().split()])
intelligence_price = int(input())

bullet_cost = 0
bullet_cnt = 0

while bullets and locks:
    bullet = bullets.pop()
    lock = locks.popleft()
    bullet_cost += bullet_price
    bullet_cnt += 1

    if bullet <= lock:
        print('Bang!')
    else:
        locks.insert(0, lock)
        print('Ping!')

    if bullet_cnt == barrel_size and bullets:
        bullet_cnt = 0
        print('Reloading!')

if locks:
    print(f"Couldn't get through. Locks left: {len(locks)}")
else:
    earned_money = intelligence_price - bullet_cost
    print(f"{len(bullets)} bullets left. Earned ${earned_money}")
