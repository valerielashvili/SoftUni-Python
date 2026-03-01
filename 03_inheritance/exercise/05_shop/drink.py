from product import Product


class Drink(Product):
    DEFAULT_QNTY = 10

    def __init__(self, name: str):
        super().__init__(name, self.DEFAULT_QNTY)
