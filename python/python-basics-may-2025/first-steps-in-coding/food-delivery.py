CHICKEN_MENU_PRICE = 10.35
FISH_MENU_PRICE = 12.40
VEGETERIAN_MENU_PRICE = 8.15
DELIVERY_PRICE = 2.50

num_chicken_menu = int(input())
num_fish_menu = int(input())
num_vegy_menu = int(input())

menu_price = num_chicken_menu * CHICKEN_MENU_PRICE + num_fish_menu * FISH_MENU_PRICE + num_vegy_menu * VEGETERIAN_MENU_PRICE
desert = menu_price * 0.20
total_price = menu_price + desert + DELIVERY_PRICE

print(total_price)
