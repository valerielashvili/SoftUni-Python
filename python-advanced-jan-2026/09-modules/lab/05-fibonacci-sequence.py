from modules.fibonacci import *

fibonacci_sequence = []

while (line := input()) != 'Stop':
    tokens = line.split()
    cmd = tokens[0]

    if cmd == 'Create':
        count = int(tokens[2])
        fibonacci_sequence = create_sequence(count)
        print(*fibonacci_sequence)
    elif cmd == 'Locate':
        number = int(tokens[1])
        result = locate_number(number, fibonacci_sequence)
        print(result)
