event = input()

daily_coffee = 0
total_coffee = 0

while event != 'END':
    if event.islower():
        daily_coffee = 1
    elif event.isupper():
        daily_coffee = 2

    if event.lower() == 'coding':
        total_coffee += daily_coffee
    elif event.lower() == 'dog' or event.lower() == 'cat':
        total_coffee += daily_coffee
    elif event.lower() == 'movie':
        total_coffee += daily_coffee

    event = input()

if total_coffee > 5:
    print("You need extra sleep")
else:
    print(total_coffee)