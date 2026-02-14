from collections import deque


potions = {
    110: 'Brew of Immortality',
    100: 'Essence of Resilience',
    90: 'Draught of Wisdom',
    80: 'Potion of Agility',
    70: 'Elixir of Strength'
}
potions = dict(sorted(potions.items(), key=lambda x: -x[0]))
crafted_substances = []
all_substances_crafted = False

substances_quantities = [int(s) for s in input().split(', ')]
crystal_energy_levels = deque(int(c) for c in input().split(', '))

# End when successfully crafted all five potions
while substances_quantities and crystal_energy_levels:
    substance = substances_quantities.pop()
    crystal = crystal_energy_levels.popleft()
    combined_energy = substance + crystal

    if combined_energy in potions.keys():
        if potions[combined_energy] not in crafted_substances:
            crafted_substances.append(potions[combined_energy])
            potions.pop(combined_energy)
    else:
        next_max_energy = next((x for x in potions.keys() if x < combined_energy), None)

        if next_max_energy:
            if potions[next_max_energy] not in crafted_substances:
                crafted_substances.append(potions[next_max_energy])
                potions.pop(next_max_energy)
                if crystal - 20 > 0:
                    crystal_energy_levels.append(crystal - 20)
        else:
            if crystal - 5 > 0:
                crystal_energy_levels.append(crystal - 5)

    if len(crafted_substances) == 5:
        break

if len(crafted_substances) == 5:
    print("Success! The alchemist has forged all potions!")
else:
    print("The alchemist failed to complete his quest.")

if crafted_substances:
    print(f"Crafted potions: {', '.join(crafted_substances)}")

if substances_quantities:
    print(f"Substances: {', '.join(map(str, substances_quantities[::-1]))}")
if crystal_energy_levels:
    print(f"Crystals: {', '.join(map(str, crystal_energy_levels))}")
