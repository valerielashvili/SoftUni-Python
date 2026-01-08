n = int(input())
pumps = [list(map(int, input().split())) for _ in range(n)]

tank = 0
start = 0
total_fuel = 0

for i in range(n):
    fuel, distance = pumps[i]
    tank += fuel - distance
    total_fuel += fuel - distance

    if tank < 0:
        start = i + 1
        tank = 0

print(start)
