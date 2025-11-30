import re

password = input()
valid_chars = re.compile(r'^\w+$')
upper_chars = re.compile(r'[A-Z]')
lower_chars = re.compile(r'[a-z]')
digit = re.compile(r'\d')

while (tokens := input()) != 'Complete':
    tokens = tokens.split(' ')
    cmd = tokens[0]

    if cmd == 'Make':
        subcmd, idx = tokens[1], int(tokens[2])
        if idx < len(password):
            if subcmd == 'Upper':
                password = password[:idx] + password[idx].upper() + password[idx + 1:]
                print(password)
            elif subcmd == 'Lower':
                password = password[:idx] + password[idx].lower() + password[idx + 1:]
                print(password)

    elif cmd == 'Insert':
        idx, char = int(tokens[1]), tokens[2]
        if idx < len(password):
            password = password[:idx] + char + password[idx:]
            print(password)

    elif cmd == 'Replace':
        char, value = tokens[1], int(tokens[2])
        if char in password:
            substr = chr(ord(char) + value)
            password = password.replace(char, substr)
            print(password)

    elif cmd == 'Validation':
        match_valid_chars = valid_chars.search(password)
        match_upper = upper_chars.search(password)
        match_lower = lower_chars.search(password)
        match_digit = digit.search(password)

        if len(password) < 8:
            print("Password must be at least 8 characters long!")
        if not match_valid_chars:
            print("Password must consist only of letters, digits and _!")
        if not match_upper:
            print("Password must consist at least one uppercase letter!")
        if not match_lower:
            print("Password must consist at least one lowercase letter!")
        if not match_digit:
            print("Password must consist at least one digit!")
