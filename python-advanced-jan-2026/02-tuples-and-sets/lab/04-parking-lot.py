n_lines = int(input())
parking_lot = set()

for _ in range(n_lines):
    direction, plate_num = input().split(', ')
    if direction == 'IN':
        parking_lot.add(plate_num)
    elif direction == 'OUT':
        parking_lot.remove(plate_num)

if parking_lot:
    [print(f'{car}') for car in parking_lot]
else:
    print("Parking Lot is Empty")
