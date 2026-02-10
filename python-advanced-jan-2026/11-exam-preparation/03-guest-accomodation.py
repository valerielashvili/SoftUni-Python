def accommodate(*args, **kwargs):
    rooms = dict(sorted(kwargs.items(), key=lambda item: (item[1], item[0])))
    occupied_rooms = {}
    available_rooms = dict(rooms)
    unaccommodated_guests = 0

    for group in args:
        assigned = False
        for room, capacity in rooms.items():

            if room not in occupied_rooms:
                if capacity == group or capacity > group:
                    occupied_rooms[room] = group
                    available_rooms.pop(room)
                    assigned = True
                    break

        if not assigned:
            unaccommodated_guests += group

    occupied_rooms_sorted = []
    if occupied_rooms:
        occupied_rooms = {k.split("_")[1]: v for k, v in occupied_rooms.items()}
        occupied_rooms_sorted = sorted(occupied_rooms.items(), key=lambda item: item[0])

    output = ''
    if occupied_rooms:
        output += f'A total of {sum(1 for x in occupied_rooms.values())} accommodations were completed!\n'
        for room, guests in occupied_rooms_sorted:
            output += f'<Room {room} accommodates {guests} guests>\n'
    else:
        output += 'No accommodations were completed!\n'

    if unaccommodated_guests > 0:
        output += f'Guests with no accommodation: {unaccommodated_guests}\n'
    if available_rooms:
        output += f'Empty rooms: {len(available_rooms)}\n'

    return output


# Example usage:
# print(accommodate(5, 4, 2, room_305=6, room_410=5, room_204=2))
# print(accommodate(10, 9, 8, room_307=6, room_802=5))
# print(accommodate(1, 2, 4, 8, room_102=3, room_101=1, room_103=2))