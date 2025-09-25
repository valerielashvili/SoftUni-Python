n_lines = int(input())

for i in range(0, n_lines):
    num = int(input())

    if num == 88:
        print("Hello")
    elif num == 86:
        print("How are you?")
    elif (num != 86 or num != 88) and num < 88:
        print("GREAT!")
    elif num > 88:
        print("Bye.")