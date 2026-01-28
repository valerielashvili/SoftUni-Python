def grocery_store(**kwargs):
    sorted_groceries = dict(sorted(kwargs.items(), key=lambda x: (-x[1], -len(x[0]), x[0])))
    result = ''
    for name, qnty in sorted_groceries.items():
        result += f'{name}: {qnty}\n'
    return result


print(grocery_store(
    bread=5,
    pasta=12,
    eggs=12,
))
