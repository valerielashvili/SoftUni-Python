from typing import Tuple


def add_contest(contest: str, secret: str, contests: dict) -> dict:
    """Add contest and secret to the 'contests' dict."""
    contests[contest] = secret
    return contests


def add_user(contest: str, secret: str, name: str, score: str, contests: dict, ranking: dict) -> dict:
    """Add user to the final ranking."""
    score = int(score)
    if validate_contest(contest, secret, contests):
        if name not in ranking.keys():
            ranking[name] = {contest: score}
        else:
            if contest in ranking[name].keys():
                if ranking[name][contest] < score:
                    ranking[name][contest] = score
            else:
                ranking[name][contest] = score
    return ranking


def validate_contest(contest: str, secret: str, contests: dict) -> bool:
    """Check if a contest is valid and a password is correct."""
    return contest in contests.keys() and secret == contests[contest]


def find_best_candidate(ranking: dict) -> Tuple[str, int]:
    """Find the best candidate with max scores."""
    name, best_score = "", 0
    for user, major in ranking.items():
        current_total = 0
        for score in major.values():
            current_total += score
        if current_total > best_score:
            best_score = current_total
            name = user
    return name, best_score


def sort_ranking(ranking: dict) -> dict:
    """Sort user ranking by name, then by score in descending order."""
    sorted_name_score = dict(sorted(ranking.items()))
    for user, major in sorted_name_score.items():
        sorted_by_score = dict(sorted(major.items(), key=lambda item: -item[1]))
        sorted_name_score[user] = sorted_by_score
    return sorted_name_score


def format_ranking(best_user: str, max_score: int, ranking: dict) -> str:
    """Format user ranking."""
    result = f"Best candidate is {best_user} with total {max_score} points.\nRanking:\n"
    for user, contest in ranking.items():
        result += f"{user}\n"
        for major, score in contest.items():
            result += f"#  {major} -> {score}\n"
    return result


contest_data = {}
ranking_results = {}

while (line := input()) != 'end of contests':
    contest_name, password = line.split(':')
    contest_data = add_contest(contest_name, password, contest_data)

while (line := input()) != 'end of submissions':
    contest_name, password, username, points = line.split('=>')
    ranking_results = add_user(contest_name, password, username, points, contest_data, ranking_results)


best_candidate, total_points = find_best_candidate(ranking_results)
output = format_ranking(best_candidate, total_points, sort_ranking(ranking_results))
print(output)
