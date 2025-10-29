resources = {}

while True:
    resource = input()
    quantity = 0

    if resource != 'stop':
        quantity = int(input())
    else:
        break
    if resource not in resources:
        resources[resource] = quantity
    else:
        resources[resource] += quantity

for resource, quantity in resources.items():
    print(f"{resource} -> {quantity}")
