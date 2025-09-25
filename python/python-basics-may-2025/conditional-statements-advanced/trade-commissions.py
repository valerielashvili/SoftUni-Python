city = input()
trade_volume = float(input())

commission = 0

if 0 <= trade_volume <= 500:
    if city == 'Sofia':
        commission = 0.05
    elif city == 'Varna':
        commission = 0.045
    elif city == 'Plovdiv':
        commission = 0.055
elif 500 < trade_volume <= 1000:
    if city == 'Sofia':
        commission = 0.07
    elif city == 'Varna':
        commission = 0.075
    elif city == 'Plovdiv':
        commission = 0.08
elif 1000 < trade_volume <= 10000:
    if city == 'Sofia':
        commission = 0.08
    elif city == 'Varna':
        commission = 0.1
    elif city == 'Plovdiv':
        commission = 0.12
elif trade_volume > 10000:
    if city == 'Sofia':
        commission = 0.12
    elif city == 'Varna':
        commission = 0.13
    elif city == 'Plovdiv':
        commission = 0.145

if commission > 0:
    commission *= trade_volume
    print(f'{commission:.2f}')
else:
    print('error')
