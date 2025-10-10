empl_happiness = input().split(' ')
happiness_factor = int(input())

empl_happiness = list(map(lambda x: int(x) * happiness_factor, empl_happiness))
filtered = list(filter(lambda x: x >= (sum(empl_happiness) / len(empl_happiness)), empl_happiness))

if len(filtered) >= len(empl_happiness) / 2:
    print(f"Score: {len(filtered)}/{len(empl_happiness)}. Employees are happy!")
else:
    print(f"Score: {len(filtered)}/{len(empl_happiness)}. Employees are not happy!")
