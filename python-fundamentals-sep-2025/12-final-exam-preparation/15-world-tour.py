string = input()

while (tokens := input()) != 'Travel':
    tokens = tokens.split(':')
    cmd = tokens[0]

    if cmd == 'Add Stop':
        idx, substr = int(tokens[1]), tokens[2]
        if idx <= len(string):
            string = string[:idx] + substr + string[idx:]
        print(string)

    elif cmd == 'Remove Stop':
        start_idx, end_idx = int(tokens[1]), int(tokens[2])
        if start_idx <= len(string) and end_idx < len(string):
            string = string[:start_idx] + string[end_idx + 1:]
        print(string)

    elif cmd == 'Switch':
        old_substr, new_substr = tokens[1:]
        if old_substr in string:
            string = string.replace(old_substr, new_substr)
        print(string)

print(f"Ready for world tour! Planned stops: {string}")
