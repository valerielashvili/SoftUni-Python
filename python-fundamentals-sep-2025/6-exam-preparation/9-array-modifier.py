numbers = [int(x) for x in input().split()]

while True:
    tokens = input().split()
    command = tokens[0]

    if command == 'swap':
        idx_1, idx_2 = int(tokens[1]), int(tokens[2])
        numbers[idx_1], numbers[idx_2] = numbers[idx_2], numbers[idx_1]
    
    elif command == 'multiply':
        idx_1, idx_2 = int(tokens[1]), int(tokens[2])
        numbers[idx_1] = numbers[idx_1] * numbers[idx_2]
    
    elif command == 'decrease':
        numbers = [x - 1 for x in numbers]
    
    elif command == 'end':
        break

print(", ".join(str(e) for e in numbers))
