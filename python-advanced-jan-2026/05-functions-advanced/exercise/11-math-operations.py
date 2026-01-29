def math_operations(*args, **kwargs):
    keys = ['a', 's', 'd', 'm']

    for i, num in enumerate(args):
        key = keys[i % 4]

        if key == 'a':
            kwargs['a'] += num
        elif key == 's':
            kwargs['s'] -= num
        elif key == 'd':
            if num != 0:
                kwargs['d'] /= num
        elif key == 'm':
            kwargs['m'] *= num

    sorted_floats = dict(sorted(kwargs.items(), key=lambda x: (-x[1], x[0])))
    result = ''
    for k, v in sorted_floats.items():
        result += f'{k}: {v:.1f}\n'
    return result

print(math_operations(2.1, 12.56, 0.0, -3.899, 6.0, -20.65, a=1, s=7, d=33, m=15))
print(math_operations(-1.0, 0.5, 1.6, 0.5, 6.1, -2.8, 80.0, a=0, s=(-2.3), d=0, m=0))
print(math_operations(6.0, a=0, s=0, d=5, m=0))
