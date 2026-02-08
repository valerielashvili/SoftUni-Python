from collections import deque


packages = [int(p) for p in input().split()]
couriers = deque([int(c) for c in input().split()])

total_weight = 0

while packages and couriers:
    package = packages.pop()
    courier = couriers.popleft()

    if courier >= package:
        total_weight += package
        courier -= package * 2

        if courier > 0:
            couriers.append(courier)

    elif courier < package:
        packages.append(package - courier)
        total_weight += courier

print(f"Total weight: {total_weight} kg")

if not packages and not couriers:
    print(f"Congratulations, all packages were delivered successfully by the couriers today.")
elif packages and not couriers:
    print(f"Unfortunately, there are no more available couriers to deliver the following packages: "
          f"{', '.join(map(str, packages))}")
elif couriers and not packages:
    print(f"Couriers are still on duty: {', '.join(map(str, couriers))} but there are no more packages to deliver.")
