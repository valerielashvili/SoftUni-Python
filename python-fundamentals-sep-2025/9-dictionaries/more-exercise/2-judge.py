def add_contest(name: str, contest: str, score: int, ranking: dict) -> dict:
    """Add contest, user and their score to the 'contest_ranking' dict."""
    if contest not in ranking.keys():
        ranking[contest] = {name: score}
    else:
        if name in ranking[contest].keys():
            if ranking[contest][name] < score:
                ranking[contest][name] = score
        else:
            ranking[contest][name] = score
    return ranking


def add_user(ranking: dict) -> dict:
    """Return user and their total score."""
    user_stats = {}
    for contest, users in ranking.items():
        for user, score in users.items():
            if user not in user_stats.keys():
                user_stats[user] = score
            else:
                user_stats[user] += score
    return user_stats


def sort_ranking(ranking: dict) -> dict:
    """Sort users by scores in descending then by name in ascending order."""
    return {
        contest: dict(sorted(users.items(), key=lambda item: (-item[1], item[0])))
        for contest, users in ranking.items()
    }


def format_ranking(ranking: dict) -> str:
    """Format overall contest ranking."""
    result = ""
    for contest, users in ranking.items():
        participant_num, rank = len(users.keys()), 1
        result += f"{contest}: {participant_num} participants\n"
        for name, score in users.items():
            result += f"{rank}. {name} <::> {score}\n"
            rank += 1
    return result


def sort_users(users: dict) -> dict:
    """
    Sort users by total scores in descending then by alphabetical order.
    The sorting is done for the individual user standing.
    """
    return dict(sorted(users.items(), key=lambda item: (-item[1], item[0])))


def format_users(users: dict) -> str:
    """Format individual user standings."""
    result, rank = "Individual standings:\n", 1
    for name, total_score in users.items():
        result += f"{rank}. {name} -> {total_score}\n"
        rank += 1
    return result


contest_ranking = {}

while (line := input()) != 'no more time':
    username, contest_name, points = line.split(' -> ')
    points = int(points)

    contest_ranking = add_contest(username, contest_name, points, contest_ranking)

output = format_ranking(sort_ranking(contest_ranking)) + format_users(sort_users(add_user(contest_ranking)))
print(output)
