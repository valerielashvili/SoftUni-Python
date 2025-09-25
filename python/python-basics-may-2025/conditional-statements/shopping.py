VIDEOCARD_PRICE = 250

budget = float(input())
videocard_num = int(input())
proc_num = int(input())
ram_num = int(input())

total_videocard_price = videocard_num * VIDEOCARD_PRICE
total_proc_price = proc_num * (total_videocard_price * 0.35)
total_ram_price = ram_num * (total_videocard_price * 0.10)

total_expenses = total_videocard_price + total_proc_price + total_ram_price

if videocard_num > proc_num:
    total_expenses -= total_expenses * 0.15

if budget >= total_expenses:
    money_left = budget - total_expenses
    print(f"You have {money_left:.2f} leva left!")
else:
    money_needed = total_expenses - budget
    print(f"Not enough money! You need {money_needed:.2f} leva more!")
