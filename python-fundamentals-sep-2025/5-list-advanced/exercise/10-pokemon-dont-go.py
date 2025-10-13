pokemons = [int(x) for x in input().split()]
elements_sum = 0

while len(pokemons) != 0:
    index = int(input())
    last_index = len(pokemons) - 1
    removed_element_value = 0

    if index < 0:
        index = 0
        removed_element_value = pokemons[index]
        pokemons[index] = pokemons[last_index]
    elif index > last_index:
        removed_element_value = pokemons[last_index]
        pokemons[last_index] = pokemons[0]
    else:
        removed_element_value = pokemons.pop(index)

    pokemons = [
        p + removed_element_value if p <= removed_element_value else
        p - removed_element_value if p > removed_element_value else p
        for p in pokemons
        ]
    
    elements_sum += removed_element_value

print(elements_sum)
