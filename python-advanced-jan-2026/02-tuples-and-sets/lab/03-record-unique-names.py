n_lines = int(input())

unique_names = set()
for _ in range(n_lines):
    unique_names.add(input())

for name in unique_names:
    print(name)
