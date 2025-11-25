password = input()

while (line := input()) != 'Done':
    tokens = line.split()
    cmd, new_password = tokens[0], ''

    if cmd == 'TakeOdd':
        for i in range(len(password)):
            if i % 2 != 0:
                new_password += password[i]
        password = new_password
        print(password)
    elif cmd == 'Cut':
        idx, length = int(tokens[1]), int(tokens[2])
        password = password[:idx] + password[idx + length:]
        print(password)
    elif cmd == 'Substitute':
        substr, substitute = tokens[1], tokens[2]
        if substr in password:
            password = password.replace(substr, substitute)
            print(password)
        else:
            print("Nothing to replace!")

print(f"Your password is: {password}")
