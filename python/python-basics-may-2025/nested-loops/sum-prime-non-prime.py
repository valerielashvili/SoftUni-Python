num = input()
prime_nums_sum = 0
non_prime_nums_sum = 0

while num != "stop":
    is_prime = True

    if int(num) > 1:
        for divider in 2, 3, 5, 7, 9:
            if int(num) != divider and int(num) % divider == 0:
                is_prime = False
    elif int(num) < 0:
        print(f"Number is negative.")
        is_prime = None

    if is_prime:
        prime_nums_sum += int(num)
    elif is_prime == False:
        non_prime_nums_sum += int(num)

    num = input()

print(f"Sum of all prime numbers is: {prime_nums_sum}\n"
      f"Sum of all non prime numbers is: {non_prime_nums_sum}")