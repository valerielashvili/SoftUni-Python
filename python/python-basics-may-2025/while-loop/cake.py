width = int(input())
length = int(input())
total_pieces = width * length

while True:
    num_pieces = input()

    if num_pieces == 'STOP':
        print(f"{total_pieces} pieces are left.")
        break

    if total_pieces - int(num_pieces) > 0:
        total_pieces -= int(num_pieces)
    elif total_pieces - int(num_pieces) < 0:
        print(f"No more cake left! You need {int(num_pieces) - total_pieces} pieces more.")
        break