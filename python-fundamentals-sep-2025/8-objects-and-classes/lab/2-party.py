class Party:
    def __init__(self):
        self.people = []

party = Party()

line = input()
while line != 'End':
    party.people.append(line)
    line = input()

print(f"Going: {', '.join(party.people)}\n"
      f"Total: {len(party.people)}")
