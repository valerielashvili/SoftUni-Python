k = int(input())
l = int(input())
m = int(input())
n = int(input())

counter = 0

for first_digit in range(k, 8 + 1):
    if first_digit % 2 == 0 and counter != 6:

        for second_digit in range(9, l - 1, -1):
            if second_digit % 2 != 0 and counter != 6:

                for third_digit in range(m, 8 + 1):
                    if third_digit % 2 == 0 and counter != 6:

                        for fourth_digit in range(9, n - 1, -1):
                            if fourth_digit % 2 != 0 and counter != 6:

                                if first_digit == third_digit and second_digit == fourth_digit:
                                    print(f"Cannot change the same player.")
                                else:
                                    print(f"{first_digit}{second_digit} - {third_digit}{fourth_digit}")
                                    counter += 1