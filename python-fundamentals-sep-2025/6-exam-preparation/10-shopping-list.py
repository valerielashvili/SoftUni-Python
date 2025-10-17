groceries = input().split('!')

while True:
    input_str = input()

    if input_str == 'Go Shopping!':
        break
    else:
        tokens = input_str.split()
        command = tokens[0]
        item = ''
        
        if len(tokens) >= 2:
            item = tokens[1]

        if command == 'Urgent' and item not in groceries:
            groceries.insert(0, item)
        
        elif item in groceries:
            if command == 'Unnecessary':
                groceries.remove(item)

            elif command == 'Correct':
                if len(tokens) >= 3:
                    new_item = tokens[2]
                    idx = groceries.index(item)
                    groceries[idx] = new_item

            elif command == 'Rearrange':
                groceries.remove(item)
                groceries.append(item)

print(", ".join(str(e) for e in groceries))
