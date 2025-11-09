def calc_position(letters_num: int, boundary: int, letter: str) -> int:
    """Return the position of an English alphabet letter."""
    return letters_num - (boundary - ord(letter))


def calc_first_num(first_l: str, num: int) -> float:
    """Calculate number of the string's first letter."""
    if first_l.isupper():
        return num / calc_position(letters_cnt, upper_ascii_bound, first_l)
    elif first_l.islower():
        return num * calc_position(letters_cnt, lower_ascii_bound, first_l)
    return 0


def calc_second_num(last_l: str, num: float) -> float:
    """Calculate number of the string's last letter."""
    if last_l.isupper():
        return num - calc_position(letters_cnt, upper_ascii_bound, last_l)
    elif last_l.islower():
        return num + calc_position(letters_cnt, lower_ascii_bound, last_l)
    return 0


letters_cnt = 26
upper_ascii_bound = 90
lower_ascii_bound = 122
total_sum = 0
strings = input().split()

for string in strings:
    first_letter, last_letter = string[0], string[-1]
    number = int(string[1:-1])

    number = calc_first_num(first_letter, number)
    number = calc_second_num(last_letter, number)
    total_sum += number

print(f"{total_sum:.2f}")
