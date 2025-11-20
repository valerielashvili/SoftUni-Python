num = int(input())
piano_pieces = {}

for n in range(num):
    tokens = input().split('|')
    piece, composer, key = tokens
    if piece not in piano_pieces:
        piano_pieces[piece] = {composer: key}

while (line := input()) != 'Stop':
    tokens = line.split('|')
    cmd = tokens[0]

    if cmd == 'Add':
        piece, composer, key = tokens[1:]
        if piece not in piano_pieces:
            piano_pieces[piece] = {composer: key}
            print(f"{piece} by {composer} in {key} added to the collection!")
        else:
            print(f"{piece} is already in the collection!")

    elif cmd == 'Remove':
        piece = tokens[1]
        if piece in piano_pieces:
            del piano_pieces[piece]
            print(f"Successfully removed {piece}!")
        else:
            print(f"Invalid operation! {piece} does not exist in the collection.")

    elif cmd == 'ChangeKey':
        piece, new_key = tokens[1:]
        if piece in piano_pieces:
            for composer in piano_pieces[piece].keys():
                piano_pieces[piece][composer] = new_key
            print(f"Changed the key of {piece} to {new_key}!")
        else:
            print(f"Invalid operation! {piece} does not exist in the collection.")

for piece, composers in piano_pieces.items():
    for composer, key in composers.items():
        print(f"{piece} -> Composer: {composer}, Key: {key}")
