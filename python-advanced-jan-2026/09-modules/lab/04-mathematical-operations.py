from modules.mathops import *

num_1, operator, num_2 = [x for x in input().split()]
num_1, num_2 = float(num_1), int(num_2)
calculate(num_1, num_2, operator)
