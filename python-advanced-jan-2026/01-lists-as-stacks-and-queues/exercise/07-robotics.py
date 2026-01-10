from collections import deque


robots = [
    {'name': name, 'process_time': int(time)}
    for name, time in (robot.split('-') for robot in input().split(';'))
]
h, m, s = map(int, input().split(':'))
current_time = h * 3600 + m * 60 + s
products = deque([])

for robot in robots:
    robot.update({'next_free_time': current_time})

while (product := input()) != 'End':
    products.append(product)

while products:
    current_time += 1
    product = products.popleft()

    for robot in robots:
        if robot['next_free_time'] <= current_time:
            robot['next_free_time'] = current_time + robot['process_time']

            # If processing goes past midnight wrap current_time back into a 24-hour clock
            t = current_time % (24 * 3600)
            h, m, s = t // 3600, (t % 3600) // 60, t % 60
            print(f"{robot['name']} - {product} [{h:02d}:{m:02d}:{s:02d}]")
            break
    else:
        products.append(product)
