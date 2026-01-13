n_lines = int(input())
unique_usernames = set()

for _ in range(n_lines):
    unique_usernames.add(input())

for name in unique_usernames:
    print(name)
