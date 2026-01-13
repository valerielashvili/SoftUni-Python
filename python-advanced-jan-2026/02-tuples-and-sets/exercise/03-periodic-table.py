n_lines = int(input())
chemical_compounds = set()

for _ in range(n_lines):
    chemical_compounds.update({c for c in input().split()})

for compound in chemical_compounds:
    print(compound)
