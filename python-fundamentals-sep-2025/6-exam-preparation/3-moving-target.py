targets = [int(t) for t in input().split()]
tokens = input().split()
command = tokens[0]

while command != 'End':
    if command == 'Shoot':
        idx, power = int(tokens[1]), int(tokens[2])

        if 0 <= idx < len(targets):
            targets[idx] -= power
            if targets[idx] <= 0:
                targets.pop(idx)

    elif command == 'Add':
        idx, value = int(tokens[1]), int(tokens[2])

        if 0 <= idx < len(targets):
            targets.insert(idx, value)
        else:
            print("Invalid placement!")

    elif command == 'Strike':
        idx, radius = int(tokens[1]), int(tokens[2])
        strt_range = idx - radius
        end_range = idx + radius + 1

        if 0 <= strt_range < len(targets) and 0 <= end_range < len(targets):
            targets = targets[:strt_range] + targets[end_range:]
        else:
            print("Strike missed!")

    tokens = input().split()
    command = tokens[0]

result = ''
for e in targets:
    result += f"{e}|"
print(result.strip('|'))
