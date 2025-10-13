strings = input().split()
command = ''

while command != '3:1':
    tokens = input().split()
    command = tokens[0]

    if command == 'merge':
        start_index = int(tokens[1])
        end_index = int(tokens[2])

        start_index = max(0, start_index)
        end_index = min(len(strings) - 1, end_index)

        if start_index <= end_index:
            merged = ''.join(strings[start_index:end_index + 1])
            strings = strings[:start_index] + [merged] + strings[end_index + 1:]

    elif command == 'divide':
        index = int(tokens[1])
        partitions = int(tokens[2])
        string_to_divide = strings.pop(index)

        part_length = len(string_to_divide) // partitions
        remainder = len(string_to_divide) % partitions

        divided_strings = []
        start = 0

        for i in range(partitions):
            current_part_length = part_length

            if i == partitions - 1:
                current_part_length += remainder

            part = string_to_divide[start:start + current_part_length]
            divided_strings.append(part)
            start += current_part_length

        strings[index:index] = divided_strings

result = ''
for element in strings:
    result += f"{element} "
print(result.strip())
