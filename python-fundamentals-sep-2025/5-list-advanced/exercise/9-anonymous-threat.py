strings = input().split()
command = ''

while command != '3:1':
    tokens = input().split()
    command = tokens[0]

    if command == 'merge':
        merged_string = ''
        start_index = int(tokens[1])
        end_index = int(tokens[2]) + 1

        if start_index < 0:
            start_index = 0
        if end_index >= len(strings):
            end_index = len(strings)

        for i in range(start_index, end_index):
            merged_string += strings[i]
            strings[i] = 'void'

        strings[start_index] = merged_string
        strings = list(filter(lambda x: x != 'void', strings))

    elif command == 'divide':
        index = int(tokens[1])
        partitions = int(tokens[2])
        string_to_divide = strings[index]
        strings[index] = 'void'

        string_length = len(string_to_divide)
        step = string_length // partitions
        substr_remainder = step + string_length % partitions
        divided_strings = []

        if string_length % partitions == 0:
            for j in range(0, string_length - 1, step):
                divided_strings.append(string_to_divide[j:j + step])
        else:
            for k in range(0, string_length - 1 - substr_remainder, step):
                divided_strings.append(string_to_divide[k:k + step])
            divided_strings.append(string_to_divide[-substr_remainder:])

        for l, element in enumerate(divided_strings):
            strings.insert(index + 1 + l, element)

        strings = list(filter(lambda x: x != 'void', strings))

result = ''
for element in strings:
    result += f"{element} "
print(result.strip())
