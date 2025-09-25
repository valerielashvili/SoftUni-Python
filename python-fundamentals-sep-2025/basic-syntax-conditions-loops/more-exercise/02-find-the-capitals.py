from curses.ascii import isupper

string = input()
capital_letters_indices = []

for i in range(len(string)):
    if isupper(string[i]):
        capital_letters_indices += [i]

print(capital_letters_indices)