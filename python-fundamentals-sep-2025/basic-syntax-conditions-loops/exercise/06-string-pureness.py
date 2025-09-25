n = int(input())

for i in range(0, n):
    input_str = input()

    for c in input_str:
        if c == ',' or c == '.' or c == '_':
            print(f"{input_str} is not pure!")
            break
    else:
        print(f"{input_str} is pure.")