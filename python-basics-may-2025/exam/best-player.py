football_player_name = input()

last_player_goals = 0
last_player_name = ""

while football_player_name != 'END':
    goals = int(input())

    if goals > last_player_goals:
        last_player_goals = goals
        last_player_name = football_player_name

    if last_player_goals >= 10:
        break

    football_player_name = input()

print(f"{last_player_name} is the best player!")

if last_player_goals >= 3 or last_player_goals >= 10:
    print(f"He has scored {last_player_goals} goals and made a hat-trick !!!")
else:
    print(f"He has scored {last_player_goals} goals.")