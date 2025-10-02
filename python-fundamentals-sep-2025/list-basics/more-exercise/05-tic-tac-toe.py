field = [input().replace(' ', '') for f in range(3)]

first_player_won = False
second_player_won = False
winner = ''

# Diagonal case
if ((field[0][0] == '1' and field[1][1] == '1' and field[2][2] == '1') or
    (field[0][2] == '1' and field[1][1] == '1' and field[2][0] == '1')):
    first_player_won = True
elif ((field[0][0] == '2' and field[1][1] == '2' and field[2][2] == '2') or
      (field[0][2] == '2' and field[1][1] == '2' and field[2][0] == '2')):
    second_player_won = True
# Horizontal case
elif field[0] == '111' or field[1] == '111' or field[2] == '111':
    first_player_won = True
elif field[0] == '222' or field[1] == '222' or field[2] == '222':
    second_player_won = True
# Vertical case
else:
    for i in range(3):
        if field[0][i] == '1' and field[1][i] == '1' and field[2][i] == '1':
            first_player_won = True
            break
        elif field[0][i] == '2' and field[1][i] == '2' and field[2][i] == '2':
            second_player_won = True
            break

if first_player_won:
    winner = "First player won"
elif second_player_won:
    winner = "Second player won"
else:
    winner = "Draw!"

print(winner)
