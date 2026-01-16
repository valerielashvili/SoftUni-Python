from collections import deque


magic_levels = {
    150: 'Doll',
    250: 'Wooden train',
    300: 'Teddy bear',
    400: 'Bicycle'
}
presents = {
    'Doll': 0,
    'Wooden train': 0,
    'Teddy bear': 0,
    'Bicycle': 0
}

materials = deque([int(m) for m in input().split()])
magic_values = deque([int(m) for m in input().split()])

while materials and magic_values:
    material = materials.pop()
    magic_value = magic_values.popleft()

    if material == 0 and magic_value == 0:
        continue
    if material == 0:
        magic_values.appendleft(magic_value)
        continue
    if magic_value == 0:
        materials.append(material)
        continue

    total_magic_value = material * magic_value

    if total_magic_value in magic_levels.keys():
        present = magic_levels[total_magic_value]
        presents[present] += 1
    else:
        if total_magic_value < 0:
            total_magic_value = material + magic_value
            materials.append(total_magic_value)
        elif total_magic_value > 0:
            material += 15
            materials.append(material)

if ((presents['Doll'] > 0 and presents['Wooden train'] > 0) or
    (presents['Teddy bear'] > 0 and presents['Bicycle'] > 0)):
    print("The presents are crafted! Merry Christmas!")
else:
    print("No presents this Christmas!")

if materials:
    materials.reverse()
    print(f"Materials left: {', '.join(map(str, materials))}")

if magic_values:
    print(f"Magic left: {', '.join(map(str, magic_values))}")

sorted_presents = dict(sorted(presents.items()))
for present in sorted_presents.items():
    if present[1] > 0:
        print(f"{present[0]}: {present[1]}")
