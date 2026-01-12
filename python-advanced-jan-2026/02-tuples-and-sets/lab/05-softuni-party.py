n_lines = int(input())
vips = set()
regular_guests = set()
attended_guests = set()
missing_vips = set()
missing_regulars = set()

for _ in range(n_lines):
    guest = input()
    if len(guest) == 8:
        if guest[0].isdigit():
            vips.add(guest)
        else:
            regular_guests.add(guest)

while (guest := input()) != 'END':
    attended_guests.add(guest)

missing_vips = vips.difference(attended_guests)
missing_regulars = regular_guests.difference(attended_guests)
num_missing_guests = len(missing_vips) + len(missing_regulars)

print(num_missing_guests)
for vip in sorted(missing_vips):
    print(vip)
for regular in sorted(missing_regulars):
    print(regular)
