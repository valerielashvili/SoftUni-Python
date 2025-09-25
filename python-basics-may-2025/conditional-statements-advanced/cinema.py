screeing_type = input()
rows = int(input())
columns = int(input())

income = 0

if screeing_type == 'Premiere':
    income += rows * columns * 12
elif screeing_type == 'Normal':
    income += rows * columns * 7.50
elif screeing_type == 'Discount':
    income += rows * columns * 5

print(f'{income:.2f}')