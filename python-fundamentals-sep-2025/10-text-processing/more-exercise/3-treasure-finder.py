keys = [int(k) for k in input().split()]

while (line := input()) != 'find':
    decrypted = ''
    for i in range(len(line)):
        decrypted += chr(ord(line[i]) - keys[i % len(keys)])

    start_type = decrypted.index('&') + 1
    end_type = start_type + decrypted[start_type:].index('&')
    treasure_type = decrypted[start_type:end_type]

    start_coord = decrypted.index('<') + 1
    end_coord = decrypted.index('>')
    coordinates = decrypted[start_coord:end_coord]

    print(f"Found {treasure_type} at {coordinates}")
