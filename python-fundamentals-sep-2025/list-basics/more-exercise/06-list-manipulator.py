import sys

numbers = [int(n) for n in input().split()]
tokens = input().split()
command = tokens[0]

greatest_num = -sys.maxsize
smallest_num = sys.maxsize

while command != 'end':

    if command == 'exchange':
        index = int(tokens[1]) + 1

        if index >= len(numbers) or index < 0:
            print("Invalid index")
        else:
            numbers = numbers[index:] + numbers[:index]

    elif command == 'max':
        action = tokens[1]

        if action == 'even':
            for i in range(len(numbers)):
                if i % 2 == 0 and numbers[i] > greatest_num:
                    greatest_num = numbers[i]
            if greatest_num < 0:
                print("No matches")
            else:
                rightmost_index = len(numbers) - 1 - numbers[::-1].index(greatest_num)
                print(rightmost_index)

        elif action == 'odd':
            for i in range(len(numbers)):
                if i % 2 == 1 and numbers[i] > greatest_num:
                    greatest_num = numbers[i]
            if greatest_num < 0:
                print("No matches")
            else:
                rightmost_index = len(numbers) - 1 - numbers[::-1].index(greatest_num)
                print(rightmost_index)

    elif command == 'min':
        action = tokens[1]

        if action == 'even':
            for i in range(len(numbers)):
                if i % 2 == 0 and numbers[i] < smallest_num:
                    smallest_num = numbers[i]
            if smallest_num == sys.maxsize:
                print("No matches")
            else:
                rightmost_index = len(numbers) - 1 - numbers[::-1].index(smallest_num)
                print(rightmost_index)

        elif action == 'odd':
            for i in range(len(numbers)):
                if i % 2 == 1 and numbers[i] < smallest_num:
                    smallest_num = numbers[i]
            if smallest_num == sys.maxsize:
                print("No matches")
            else:
                rightmost_index = len(numbers) - 1 - numbers[::-1].index(smallest_num)
                print(rightmost_index)

    elif command == 'first':
        action = tokens[2]
        count = int(tokens[1])
        first_count_elements = []

        if count > len(numbers):
            print("Invalid count")
        else:
            if action == 'even':
                for i in numbers:
                    if i % 2 == 0:
                        first_count_elements.append(numbers[i])
            elif action == 'odd':
                for i in numbers:
                    if i % 2 == 1:
                        first_count_elements.append(numbers[i])

            print(first_count_elements[:count])

    elif command == 'last':
        action = tokens[2]
        count = int(tokens[1])
        last_count_elements = []

        if count > len(numbers):
            print("Invalid count")
        else:
            if action == 'even':
                for i in numbers:
                    if i % 2 == 0:
                        last_count_elements.append(numbers[i])
            elif action == 'odd':
                for i in numbers:
                    if i % 2 == 1:
                        last_count_elements.append(numbers[i])

            print(last_count_elements[-count:])

    tokens = input().split()
    command = tokens[0]

print(numbers)
