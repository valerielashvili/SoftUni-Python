usr_input = input()
balance = 0

while usr_input != "NoMoreMoney":
    if float(usr_input) < 0:
        print("Invalid operation!")
        break

    balance += float(usr_input)
    print(f"Increase: {float(usr_input):.2f}")
    usr_input = input()

print(f"Total: {balance:.2f}")