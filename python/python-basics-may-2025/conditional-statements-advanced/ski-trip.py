days = int(input()) - 1
accommodation = input()
rating = input()

price = 0

if accommodation == 'room for one person':
    price = days * 18
elif accommodation == 'apartment':
    price = days * 25

    if days < 10:
        price -= price * 0.3
    elif 10 <= days <= 15:
        price -= price * 0.35
    elif days > 15:
        price -= price * 0.5

elif accommodation == 'president apartment':
    price = days * 35

    if days < 10:
        price -= price * 0.1
    elif 10 <= days <= 15:
        price -= price * 0.15
    elif days > 15:
        price -= price * 0.2

if rating == 'positive':
    price += price * 0.25
else:
    price -= price * 0.1

print(f"{price:.2f}")
