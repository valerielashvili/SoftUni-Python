message = input()

while (line := input()) != 'Reveal':
    tokens = line.split(':|:')
    command = tokens[0]

    if command == 'InsertSpace':
        idx = int(tokens[1])
        message = message[:idx] + " " + message[idx:]
    elif command == 'Reverse':
        substr = tokens[1]
        if substr in message:
            message = message.replace(substr, '', 1)
            message += substr[::-1]
        else:
            print("error")
            continue
    elif command == 'ChangeAll':
        substr, replacement = tokens[1:]
        message = message.replace(substr, replacement)

    print(message)

print(f"You have a new text message: {message}")
