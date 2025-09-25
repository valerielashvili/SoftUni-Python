first_num = int(input())
second_num = int(input())

digit_one_start_range = first_num // 1000
digit_one_end_range = second_num // 1000

digit_two_start_range = first_num // 100 % 10
digit_two_end_range = second_num // 100 % 10

digit_three_start_range = first_num // 10 % 10
digit_three_end_range = second_num // 10 % 10

digit_four_start_range = first_num % 10
digit_four_end_range = second_num % 10

for i in range(digit_one_start_range, digit_one_end_range + 1):

    if i % 2 != 0:
        for j in range(digit_two_start_range, digit_two_end_range + 1):
            if j % 2 != 0:
                for k in range(digit_three_start_range, digit_three_end_range + 1):
                    if k % 2 != 0:
                        for l in range(digit_four_start_range, digit_four_end_range + 1):
                            if l % 2 != 0:
                                print(f"{i}{j}{k}{l}", end=" ")