def boarding_passengers(capacity, *args):
    guests = [*args]
    board = {'Diamond': 0, 'Platinum': 0, 'Gold': 0, 'First Cruiser': 0}
    for i, group in enumerate(guests):
        passengers, program = group
        if capacity >= passengers and program in board:
            board[program] += passengers
            capacity -= passengers
            guests[i] = None
        elif capacity < passengers:
            continue
        elif capacity == 0:
            break

    if all(x is None for x in guests):
        guests = []

    sorted_passengers = dict(sorted(board.items(), key=lambda item: (-item[1], item[0])))

    result = 'Boarding details by benefit plan:\n'
    for program, passengers_num in sorted_passengers.items():
        if passengers_num > 0:
            result += f'## {program}: {passengers_num} guests\n'

    if not guests:
        result += 'All passengers are successfully boarded!'
    elif capacity == 0 and guests:
        result += 'Boarding unsuccessful. Cruise ship at full capacity.'
    elif capacity > 0 and guests:
        result += f'Partial boarding completed. Available capacity: {capacity}.'

    return result


print(boarding_passengers(150, (35, 'Diamond'), (55, 'Platinum'), (35, 'Gold'), (25, 'First Cruiser')))
# print(boarding_passengers(
#     100, (20, 'Diamond'), (15, 'Platinum'), (25, 'Gold'),
#     (25, 'First Cruiser'), (15, 'Diamond'), (10, 'Gold'))
# )
# print(boarding_passengers(
#     120, (30, 'Gold'), (20, 'Platinum'), (30, 'Diamond'),
#     (10, 'First Cruiser'), (31, 'Platinum'), (20, 'Diamond'))
# )
