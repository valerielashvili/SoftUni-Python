width = int(input())
length = int(input())
height = int(input())
apartment_space = width * length * height

while True:
    num_boxes = input()

    if num_boxes == 'Done':
        print(f"{apartment_space} Cubic meters left.")
        break
    elif int(num_boxes) > 0:
        apartment_space -= int(num_boxes)

    if apartment_space < 0:
        print(f"No more free space! You need {abs(apartment_space)} Cubic meters more.")
        break