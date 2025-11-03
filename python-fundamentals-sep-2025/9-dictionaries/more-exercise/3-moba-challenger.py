import re


def add_player(name: str, role: str, power: int, players: dict) -> dict:
    """Add player to the Challenger tier."""
    if name not in players.keys():
        players[name] = {role: power}
    else:
        if role not in players[name].keys():
            players[name][role] = power
        else:
            if players[name][role] < power:
                players[name][role] = power
    return players


def play_duel(name_1: str, name_2: str, players: dict) -> dict:
    """Demote a player with the least skills."""
    if name_1 in players.keys() and name_2 in players.keys():
        for role in players[name_1].keys():
            if role in (enemy_roles for enemy_roles in players[name_2].keys()):
                if sum(players[name_1].values()) < sum(players[name_2].values()):
                    players.pop(name_1)
                else:
                    players.pop(name_2)
    return players


def sort_players(players: dict) -> dict:
    return dict(sorted(players.items(), key=lambda item: (-sum(item[1].values()), item[0])))


def sort_positions(roles: dict) -> dict:
    return dict(sorted(roles.items(), key=lambda item: (-item[1], item[0])))


def format_output(players: dict) -> str:
    output = ""
    for name, roles in players.items():
        output += f"{name}: {sum(roles.values())} skill\n"
        roles = sort_positions(roles)
        for role, power in roles.items():
            output += f"- {role} <::> {power}\n"
    return output


players_pool = {}

while (line := input()) != 'Season end':
    tokens = re.split(r' -> | vs ', line) + [None]
    player, position, skill = tokens[:3]

    if skill is not None:
        players_pool = add_player(player, position, int(skill), players_pool)
    else:
        player_1, player_2 = player, position
        players_pool = play_duel(player_1, player_2, players_pool)

result = format_output(sort_players(players_pool))
print(result)
