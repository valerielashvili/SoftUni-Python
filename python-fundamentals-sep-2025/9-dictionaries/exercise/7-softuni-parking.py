def register_car(dr_name: str, car_plate: str, parking_lot: dict):
    if dr_name not in parking_lot:
        parking_lot[dr_name] = car_plate
        result = f"{dr_name} registered {car_plate} successfully"
    else:
        result = f"ERROR: already registered with plate number {parking_lot[dr_name]}"
    return parking_lot, result


def unregister_car(dr_name: str, parking_lot: dict):
    result = parking_lot.pop(dr_name, f"ERROR: user {dr_name} not found")
    if 'ERROR' not in result:
        result = f"{dr_name} unregistered successfully"
    return parking_lot, result


n_lines = int(input())
parking = {}

for n in range(n_lines):
    tokens = input().split() + [None]
    command, name, plate_num = tokens[:3]

    if command == 'register':
        parking, print_result = register_car(name, plate_num, parking)
        print(print_result)
    elif command == 'unregister':
        parking, print_result = unregister_car(name, parking)
        print(print_result)

for name, plate_num in parking.items():
    print(f"{name} => {plate_num}")
