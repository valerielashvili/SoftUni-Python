class Catalogue:
    def __init__(self, name: str):
        self.name = name
        self.products = []

    def add_product(self, product_name: str):
        self.products.append(product_name)

    def get_by_letter(self, first_letter: str):
        products_by_letter = list(filter(lambda p: p[0] == first_letter, self.products))
        return products_by_letter

    def __repr__(self):
        result = f"Items in the {self.name} catalogue:\n"
        result += '\n'.join(sorted(self.products))
        return result

catalogue = Catalogue("Furniture")
catalogue.add_product("Sofa")
catalogue.add_product("Mirror")
catalogue.add_product("Desk")
catalogue.add_product("Chair")
catalogue.add_product("Carpet")
print(catalogue.get_by_letter("C"))
print(catalogue)
