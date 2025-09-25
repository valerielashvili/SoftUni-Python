year_tax = int(input())

sneakers = year_tax - (year_tax * 0.40)
equipment = sneakers - (sneakers * 0.20)
ball = equipment / 4
accessories = ball / 5

total_expenses = year_tax + sneakers + equipment + ball + accessories

print(total_expenses)
