string = input()

numbers_list = [int(x) for x in string if x.isdigit()]
char_string = "".join(c for c in string if not c.isdigit())
take_list = [val for idx, val in enumerate(numbers_list) if idx % 2 == 0]
skip_list = [val for idx, val in enumerate(numbers_list) if idx % 2 != 0]
hidden_message = ''

for take, skip in zip(take_list, skip_list):
    hidden_message += char_string[:take]
    char_string = char_string[take:]
    char_string = char_string[skip:]

print(hidden_message)
