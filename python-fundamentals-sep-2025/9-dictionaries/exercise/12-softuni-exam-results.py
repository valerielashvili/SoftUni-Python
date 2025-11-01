from typing import Tuple


def split_input(input_ln: str) -> Tuple[str, str, int | None]:
    """Split user input and cast 'score' to int if provided."""
    tokens = input_ln.split('-') + [None]
    user, lang, score = tokens[:3]
    if lang != 'banned':
        score = int(tokens[2])
    return user, lang, score


def submit_result(user: str, lang: str, score: int, results: dict) -> dict:
    """Save user submissions with their points."""
    if lang not in results.keys():
        results[lang] = {user: [score]}
    elif user not in results[lang].keys():
        results[lang].update({user: [score]})
    else:
        results[lang][user].append(score)
    return results


def ban_user(user: str, results: dict) -> dict:
    """Set the ban flag if received."""
    for lang in results.keys():
        if user in results[lang]:
            results[lang][user].append('ban')
    return results


def format_results(results: dict) -> str:
    """Format exam results by pupil."""
    output = "Results:\n"
    for user in results.values():
        for name, scores in user.items():
            if scores[-1] != 'ban':
                output += f"{name} | {max(scores)}\n"
    return output


def format_submissions(results: dict) -> str:
    """Format total submissions by language"""
    output = "Submissions:\n"
    for lang in results.keys():
        nested_cnt = sum(
            1 for scores in results[lang].values()
            for score in scores
            if score != 'ban'
            if isinstance(scores, list)
        )
        output += f"{lang} - {nested_cnt}\n"
    return output


exam_results = {}

while (line := input()) != 'exam finished':
    username, language, points = split_input(line)

    if language == 'banned':
        exam_results = ban_user(username, exam_results)
    else:
        exam_results = submit_result(username, language, points, exam_results)

exam_stats = format_results(exam_results) + format_submissions(exam_results)
print(exam_stats)
