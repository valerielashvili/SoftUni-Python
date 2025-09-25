month = input()
days = int(input())

studio_price = 0
apart_price = 0

if month == 'May' or month == 'October':
    studio_price = 50
    apart_price = 65

    if 7 < days <= 14:
        studio_price -= studio_price * 0.05
    elif days > 14:
        studio_price -= studio_price * 0.3
        apart_price -= apart_price * 0.1

elif month == 'June' or month == 'September':
    studio_price = 75.20
    apart_price = 68.70

    if days > 14:
        studio_price -= studio_price * 0.2
        apart_price -= apart_price * 0.1

elif month == 'July' or month == 'August':
    studio_price = 76
    apart_price = 77

    if days > 14:
        apart_price -= apart_price * 0.1

print(f"Apartment: {days * apart_price:.2f} lv.\n"
      f"Studio: {days * studio_price:.2f} lv.")
