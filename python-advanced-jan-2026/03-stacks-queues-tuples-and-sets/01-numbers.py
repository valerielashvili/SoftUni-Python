first_seq = set(map(int, input().split()))
second_seq = set(map(int, input().split()))
n_lines = int(input())

for _ in range(n_lines):
    tokens = input().split()
    command, numbers = str(tokens[0] + ' ' + tokens[1]), set(map(int, tokens[2:]))

    if command == 'Add First':
        first_seq.update(numbers)
    elif command == 'Add Second':
        second_seq.update(numbers)
    elif command == 'Remove First':
        first_seq = first_seq - numbers
    elif command == 'Remove Second':
        second_seq = second_seq - numbers
    elif command == 'Check Subset':
        if first_seq < second_seq or second_seq < first_seq:
            print('True')
        else:
            print('False')

first_seq_sorted = sorted(first_seq)
second_seq_sorted = sorted(second_seq)
print(f"{', '.join(map(str, first_seq_sorted))}")
print(f"{', '.join(map(str, second_seq_sorted))}")
