import sys

usr_input = input()
biggest = -sys.maxsize

while usr_input != "Stop":
    if int(usr_input) > biggest:
        biggest = int(usr_input)
        
    usr_input = input()

print(biggest)