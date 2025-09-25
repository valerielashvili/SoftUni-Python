input_str = input()

double_char = ""

while input_str != 'End':

    if input_str != "SoftUni":
        for c in input_str:
            double_char += c * 2

        print(double_char)
        double_char = ""

    input_str = input()