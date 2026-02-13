def list_roman_emperors(*args, **kwargs):
    successful_emperors = {e[0]: kwargs[e[0]] for e in args if e[0] in kwargs and e[1] == True}
    unsuccessful_emperors = {e[0]: kwargs[e[0]] for e in args if e[0] in kwargs and e[1] == False}

    sorted_successful = dict(sorted(successful_emperors.items(), key=lambda x: (-x[1], x[0])))
    sorted_unsuccessful = dict(sorted(unsuccessful_emperors.items(), key=lambda x: (x[1], x[0])))

    output = f"Total number of emperors: {len(sorted_successful) + len(sorted_unsuccessful)}\n"
    if sorted_successful:
        output += "Successful emperors:\n"
        for name, rule_length in sorted_successful.items():
            output += f"****{name}: {rule_length}\n"

    if sorted_unsuccessful:
        output += "Unsuccessful emperors:\n"
        for name, rule_length in sorted_unsuccessful.items():
            output += f"****{name}: {rule_length}\n"

    return output

# Example usage:
#print(list_roman_emperors(("Augustus", True), ("Nero", False), Augustus=40, Nero=14,))

print(list_roman_emperors(
    ("Augustus", True),
    ("Trajan", True),
    ("Nero", False),
    ("Caligula", False),
    ("Pertinax", False),
    ("Vespasian", True),
    Augustus=40,
    Trajan=19,
    Nero=14,
    Caligula=4,
    Pertinax=4,
    Vespasian=19,)
)

# print(list_roman_emperors(
#     ("Augustus", True),
#     ("Trajan", True),
#     ("Claudius", True),
#     Augustus=40,
#     Trajan=19,
#     Claudius=13,)
# )
