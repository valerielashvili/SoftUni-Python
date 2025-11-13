import re

pattern = re.compile(r'(?P<name>[A-Za-z])|(?P<digit>\d)')
racers = {n: 0 for n in input().split(', ')}

while (string := input()) != 'end of race':
    name, distance = '', 0
    for m in pattern.finditer(string):
        if m.group('name'):
            name +=  m.group('name')
        elif m.group('digit'):
            distance += int(m.group('digit'))

    if name in racers:
        racers[name] += distance

sorted_racers = dict(sorted(racers.items(), key=lambda item: (-item[1])))
winners = list(sorted_racers)[:3]

print(f"1st place: {winners[0]}\n"
      f"2nd place: {winners[1]}\n"
      f"3rd place: {winners[2]}")
