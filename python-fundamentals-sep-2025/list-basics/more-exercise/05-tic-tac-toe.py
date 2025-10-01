field = [input().replace(' ', '') for f in range(3)]

first_player_won = False
second_player_won = False
winner = ''

if field[0][0] == '1' and field[1][1] == '1' and field[2][2] == '1':
    first_player_won = True
elif field[0][0] == '2' and field[1][1] == '2' and field[2][2] == '2':
    second_player_won = True
elif field[0][2] == '1' and field[1][1] == '1' and field[2][0] == '1':
    first_player_won = True
elif field[0][2] == '2' and field[1][1] == '2' and field[2][0] == '2':
    second_player_won = True
else:
    for line in field:
        if line == '111':
            first_player_won = True
            break
        elif line == '222':
            second_player_won = True

if first_player_won:
    winner = "First player won"
elif second_player_won:
    winner = "Second player won"
else:
    winner = "Draw!"

print(winner)