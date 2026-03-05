from dough import Dough
from topping import Topping

class Pizza:
    def __init__(
            self,
            name: str,
            dough: Dough,
            max_number_of_toppings: int
    ):
        self.name = name
        self.dough = dough
        self.max_number_of_toppings = max_number_of_toppings
        self.toppings = {}

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, name):
        if name:
            self.__name = name
        else:
            raise ValueError("The name cannot be an empty string")

    @property
    def dough(self):
        return self.__dough

    @dough.setter
    def dough(self, dough: Dough):
        if dough:
            self.__dough = dough
        else:
            raise ValueError("You should add dough to the pizza")

    @property
    def max_number_of_toppings(self):
        return self.__max_number_of_toppings

    @max_number_of_toppings.setter
    def max_number_of_toppings(self, max_number_of_toppings: int):
        if max_number_of_toppings:
            self.__max_number_of_toppings = max_number_of_toppings
        else:
            raise ValueError("The maximum number of toppings cannot be less or equal to zero")

    def add_topping(self, topping: Topping):
        if len(self.toppings) == self.max_number_of_toppings:
            raise ValueError("Not enough space for another topping")

        if topping.topping_type not in self.toppings:
            self.toppings[topping.topping_type] = topping.weight
        else:
            self.toppings[topping.topping_type] += topping.weight

    def calculate_total_weight(self):
        return self.dough.weight + sum(self.toppings.values())
