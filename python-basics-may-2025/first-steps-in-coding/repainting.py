NYLON_PRICE = 1.50
PAINT_PRICE = 14.50
DETERGENT_PRICE = 5
BAGS_PRICE = 0.40

nylon_sq_meter = int(input())
paint_amount_l = int(input())
detergent_amount_l = int(input())
hours = int(input())

nylon_expense = (nylon_sq_meter + 2) * NYLON_PRICE
paint_expense = (paint_amount_l + paint_amount_l * 0.10) * PAINT_PRICE
detergent_expense = detergent_amount_l * DETERGENT_PRICE

material_expenses = nylon_expense + paint_expense + detergent_expense + BAGS_PRICE
labor_expense = material_expenses * 0.30 * hours

all_expenses = material_expenses + labor_expense

print(all_expenses)
