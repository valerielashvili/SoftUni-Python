def sorting_cheeses(**kwargs):
    cheeses_dict = sorted(kwargs.items(), key=lambda x: (-len(x[1]), x[0]))
    sorted_cheeses = []

    for name, qnty in cheeses_dict:
        sorted_cheeses.append(name)
        qnty_list = sorted(qnty, reverse=True)
        sorted_cheeses += qnty_list

    return '\n'.join([str(x) for x in sorted_cheeses])


print(
    sorting_cheeses(
        Parmesan=[102, 120, 135],
        Camembert=[100, 100, 105, 500, 430],
        Mozzarella=[50, 125],
    )
)
