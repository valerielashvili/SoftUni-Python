num_paper_roll = int(input())
num_tissue_roll = int(input())
glue_liters = float(input())
discount = int(input())

paper_roll_price = 5.80
tissue_roll_price = 7.20
glue_price = 1.20
discount = discount / 100

paper_cost = num_paper_roll * paper_roll_price
tissue_cost = num_tissue_roll * tissue_roll_price
glue_cost = glue_liters * glue_price

total_to_pay = paper_cost + tissue_cost + glue_cost
total_to_pay -= total_to_pay * discount

print(f"{total_to_pay:.3f}")