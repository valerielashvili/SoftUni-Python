PEN_PRICE = 5.80
MARKER_PRICE = 7.20
DETERGENT_PRICE = 1.20

num_pen_packs = int(input())
num_marker_packs = int(input())
num_detergent_liters = int(input())
discount = int(input()) / 100

total_pen_price = num_pen_packs * PEN_PRICE
total_marker_price = num_marker_packs * MARKER_PRICE
total_detergent_price = num_detergent_liters * DETERGENT_PRICE

total_price = (total_pen_price + total_marker_price + total_detergent_price)
total_price -= total_price * discount

print(total_price)
