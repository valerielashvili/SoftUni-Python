vacation_days = int(input())
accommodation_type = input()
feedback = input()

one_person_room_price  = 18.00
apartment_price = 25.00
president_apartment_price = 35.00

vacation_days -= 1
discount = 0
total_to_pay = 0

if accommodation_type == 'apartment':
    if vacation_days < 10:
        discount = 0.3
    elif 10 <= vacation_days <= 15:
        discount = 0.35
    elif vacation_days > 15:
        discount = 0.5
elif accommodation_type == 'president apartment':
    if vacation_days < 10:
        discount = 0.1
    elif 10 <= vacation_days <= 15:
        discount = 0.15
    elif vacation_days > 15:
        discount = 0.2

if accommodation_type == 'apartment':
    total_to_pay = vacation_days * apartment_price
elif accommodation_type == 'president apartment':
    total_to_pay = vacation_days * president_apartment_price
elif accommodation_type == 'room for one person':
    total_to_pay = vacation_days * one_person_room_price

total_to_pay -= total_to_pay * discount

if feedback == 'positive':
    total_to_pay += total_to_pay * 0.25
else:
    total_to_pay -= total_to_pay * 0.1

print(f"{total_to_pay:.2f}")