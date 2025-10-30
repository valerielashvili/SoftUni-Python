countries = input().split(', ')
capitals = input().split(', ')

countries_dict = {a:b for a, b in zip(countries, capitals)}

for country, capital in countries_dict.items():
    print(f"{country} -> {capital}")
