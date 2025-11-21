message = input()

while (line := input()) != 'Decode':
    tokens = line.split('|')
    cmd = tokens[0]

    if cmd == 'Move':
        n_letters = int(tokens[1])
        message = message[n_letters:] + message[:n_letters]
    elif cmd == 'Insert':
        idx, value = int(tokens[1]), tokens[2]
        message = message[:idx] + value + message[idx:]
    elif cmd == 'ChangeAll':
        substr, replacement = tokens[1:]
        message = message.replace(substr, replacement)

print(f"The decrypted message is: {message}")
