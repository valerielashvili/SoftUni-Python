strings = input().split()
analyzed_strings = []
command = ''

while command != '3:1':
    tokens = input().split()
    command = tokens[0]

    if command == 'merge':
        merged_string = ''
        start_index = int(tokens[1])
        end_index = int(tokens[2])

        if start_index < 0:
            start_index = 0
        if end_index >= len(strings):
            end_index = len(strings) - 1

        for i in range(start_index, end_index):
            merged_string += strings[i]
            strings[i] = 'void'

        strings = [merged_string] + list(filter(lambda x: x != 'void', strings))

    elif command == 'divide':
        index = tokens[1]
        partitions = tokens[2]

print(strings)