input_str = input()
phonebook = {}
search_cnt = 0

while not input_str.isdigit():
    tokens = input_str.split('-')
    name, phone_num = tokens[0], tokens[1]
    phonebook[name] = phone_num

    input_str = input()

search_cnt = int(input_str)

for n in range(search_cnt):
    search_name = input()
    if search_name in phonebook.keys():
        print(f"{search_name} -> {phonebook[search_name]}")
    else:
        print(f"Contact {search_name} does not exist.")
