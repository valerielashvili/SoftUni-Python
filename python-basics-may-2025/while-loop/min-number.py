import sys

usr_input = input()
smallest = sys.maxsize

while usr_input != "Stop":
    if int(usr_input) < smallest:
        smallest = int(usr_input)

    usr_input = input()

print(smallest)