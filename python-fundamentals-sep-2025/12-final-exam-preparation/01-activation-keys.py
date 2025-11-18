activation_key = input()

while (string := input()) != 'Generate':
    tokens = string.split('>>>')
    command = tokens[0]

    if command == 'Contains':
        substr = tokens[1]
        if substr in activation_key:
            print(f"{activation_key} contains {substr}")
        else:
            print(f"Substring not found!")

    elif command == 'Flip':
        case, start_idx, end_idx = tokens[1], int(tokens[2]), int(tokens[3])
        substr = ''
        if case == 'Upper':
            substr = activation_key[start_idx:end_idx].upper()
        elif case == 'Lower':
            substr = activation_key[start_idx:end_idx].lower()

        activation_key = activation_key[:start_idx] + substr + activation_key[end_idx:]
        print(activation_key)

    elif command == 'Slice':
        start_idx, end_idx = int(tokens[1]), int(tokens[2])
        activation_key = activation_key[:start_idx] + activation_key[end_idx:]
        print(activation_key)

print(f"Your activation key is: {activation_key}")
