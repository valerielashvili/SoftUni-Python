first_string = input()
second_string = input()

mutated_string = ""
str_len = len(first_string)

for i in range(0, str_len):
    mutated_string = second_string[:i + 1] + first_string[i + 1:]

    if second_string[i] != first_string[i]:
        print(mutated_string)