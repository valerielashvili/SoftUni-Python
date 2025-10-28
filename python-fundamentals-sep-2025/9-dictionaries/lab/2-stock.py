products = input().split()
check_list = input().split()

stock = {products[i]:int(products[i + 1]) for i in range(0, len(products), 2)}

for product in check_list:
    if product in stock:
        print(f"We have {stock[product]} of {product} left")
    else:
        print(f"Sorry, we don't have {product}")
