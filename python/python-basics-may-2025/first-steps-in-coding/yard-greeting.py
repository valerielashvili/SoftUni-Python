SERVICE_PRICE = 7.61
DISCOUNT_RATE = 0.18

num_sq_meters = float(input())

total_price = num_sq_meters * SERVICE_PRICE
discount = total_price * DISCOUNT_RATE
final_price = total_price - discount

print(f"The final price is: {final_price} lv.\n"
      f"The discount is: {discount} lv.")