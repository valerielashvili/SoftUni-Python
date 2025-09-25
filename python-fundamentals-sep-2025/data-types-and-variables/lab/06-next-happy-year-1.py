next_year = int(input()) + 1
happy_year = ""

while True:
    next_year_str = str(next_year)

    for c in next_year_str:
        if c not in happy_year:
            happy_year += c
    
    if happy_year == next_year_str:
        break
    
    next_year += 1
    happy_year = ""

print(happy_year)