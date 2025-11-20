import re

string = input()
place_regex = re.compile(r'([=/])(?P<destination>[A-Z][A-Za-z]{2,})\1')
destinations = []
travel_points = 0

for match in place_regex.finditer(string):
    if match:
        destinations.append(match.group('destination'))
        travel_points += len(match.group('destination'))

output = f"Destinations: {', '.join(destinations)}\n" + \
         f"Travel Points: {travel_points}"
print(output)
