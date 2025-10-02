import sys

numbers = [int(n) for n in input().split()]
tokens = input().split()
command = tokens[0]

greatest_num = -sys.maxsize
smallest_num = sys.maxsize

while command != 'end':

    if command == 'exchange':
        index = int(tokens[1])

        if index > len(numbers) - 1 or index < 0:
            print("Invalid index")
        else:
            index += 1
            numbers = numbers[index:] + numbers[:index]

    elif command == 'max':
        action = tokens[1]

        if action == 'even':
            for i in range(len(numbers)):
                if numbers[i] % 2 == 0 and numbers[i] > greatest_num:
                    greatest_num = numbers[i]

        elif action == 'odd':
            for j in range(len(numbers)):
                if numbers[j] % 2 == 1 and numbers[j] > greatest_num:
                    greatest_num = numbers[j]
        
        if greatest_num <= 0:
            print("No matches")
        else:
            if numbers.count(greatest_num) > 1:
                rightmost_index = len(numbers) - 1 - numbers[::-1].index(greatest_num)
                print(rightmost_index)
            else:
                print(numbers.index(greatest_num))
        
        greatest_num = -sys.maxsize

    elif command == 'min':
        action = tokens[1]

        if action == 'even':
            for k in range(len(numbers)):
                if numbers[k] % 2 == 0 and numbers[k] < smallest_num:
                    smallest_num = numbers[k]
        elif action == 'odd':
            for l in range(len(numbers)):
                if numbers[l] % 2 == 1 and numbers[l] < smallest_num:
                    smallest_num = numbers[l]

        if smallest_num == sys.maxsize:
            print("No matches")
        else:
            if numbers.count(smallest_num) > 1:
                rightmost_index = len(numbers) - 1 - numbers[::-1].index(smallest_num)
                print(rightmost_index)
            else:
                print(numbers.index(smallest_num))
        
        smallest_num = sys.maxsize

    elif command == 'first':
        action = tokens[2]
        count = int(tokens[1])
        first_count_elements = []

        if count > len(numbers):
            print("Invalid count")
        else:
            if action == 'even':
                for num in numbers:
                    if num % 2 == 0:
                        first_count_elements.append(num)
            elif action == 'odd':
                for num in numbers:
                    if num % 2 == 1:
                        first_count_elements.append(num)

            print(first_count_elements[:count])
        
        first_count_elements = []

    elif command == 'last':
        action = tokens[2]
        count = int(tokens[1])
        last_count_elements = []

        if count > len(numbers):
            print("Invalid count")
        else:
            if action == 'even':
                for n in numbers:
                    if n % 2 == 0:
                        last_count_elements.append(n)
            elif action == 'odd':
                for n in numbers:
                    if n % 2 == 1:
                        last_count_elements.append(n)

            print(last_count_elements[-count:])
        
        last_count_elements = []

    tokens = input().split()
    command = tokens[0]

print(numbers)
