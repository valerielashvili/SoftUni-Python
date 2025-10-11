num_of_electrons = int(input())
filled_shells = []

while num_of_electrons != 0:
    shell_position = len(filled_shells) + 1
    max_num_electrons = 2 * shell_position ** 2

    if max_num_electrons <= num_of_electrons:
        filled_shells.append(max_num_electrons)
        num_of_electrons -= max_num_electrons
    else:
        filled_shells.append(num_of_electrons)
        num_of_electrons -= num_of_electrons

print(filled_shells)
