train_length = int(input())
train = [0] * train_length
command = input()

while command != 'End':
    tokens = command.split(' ')
    key_word = tokens[0]
    i, people = 0, 0

    if len(tokens) == 2:
        people = int(tokens[1])
    elif len(tokens) == 3:
        i = int(tokens[1])
        people = int(tokens[2])

    if key_word == 'add':
        train[-1] += people
    elif key_word == 'insert':
        train[i] += people
    elif key_word == 'leave':
        train[i] = train[i] - people

    command = input()
print(train)
