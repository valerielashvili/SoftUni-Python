referee_cards = set(input().split())
team_a = [f"A-{num}" for num in range(1, 12)]
team_b = [f"B-{num}" for num in range(1, 12)]

game_terminated = False

for player in referee_cards:
    if player in team_a:
        team_a.remove(player)
    elif player in team_b:
        team_b.remove(player)

    if len(team_a) < 7 or len(team_b) < 7:
        game_terminated = True
        break

print(f"Team A - {len(team_a)}; Team B - {len(team_b)}")

if game_terminated:
    print("Game was terminated")
