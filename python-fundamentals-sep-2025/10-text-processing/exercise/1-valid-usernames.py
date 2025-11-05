usernames = input().split(', ')
valid = True

for username in usernames:
    if 3 <= len(username) <= 16:
        for c in username:
            if c.isalpha() or c.isdigit() or c == '-' or c == '_':
                continue
            else:
                valid = False
                break

        if valid:
            print(username)

    valid = True
