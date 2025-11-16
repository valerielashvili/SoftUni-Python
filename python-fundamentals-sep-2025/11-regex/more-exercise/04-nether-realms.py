import re

delimit = re.compile(r'\s*,\s*')
demon_names = delimit.split(input())

health_regex = re.compile(r'[^0-9+\-*/.]')
damage_regex = re.compile(r'[-+]?[0-9]+(?:\.[0-9]+)?')
op_rx = re.compile(r'[*/]')

demons = {}

for name in demon_names:
    total_health = sum(ord(c) for c in health_regex.findall(name))
    base_damage = sum(float(n) for n in damage_regex.findall(name))
    operators = op_rx.findall(name)

    for op in operators:
        if op == '*':
            base_damage *= 2
        elif op == '/':
            base_damage /= 2

    demons[name] = {'health': total_health, 'damage': base_damage}

sorted_names = dict(sorted(demons.items()))

for name, value in sorted_names.items():
    print(f"{name} - {value['health']} health, {value['damage']:.2f} damage")
