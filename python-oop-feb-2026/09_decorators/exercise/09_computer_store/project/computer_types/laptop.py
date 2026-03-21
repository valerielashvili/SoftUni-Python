import math
from project.computer_types.computer import Computer


class Laptop(Computer):
    VALID_MODELS = {
        "AMD Ryzen 9 5950X": 900,
        "Intel Core i9-11900H": 1050,
        "Apple M1 Pro": 1200
    }
    MAX_RAM = 64

    def __init__(self, manufacturer: str, model: str):
        super().__init__(manufacturer, model)

    def configure_computer(self, processor: str, ram: int):
        if processor not in Laptop.VALID_MODELS:
            raise ValueError(
                f"{processor} is not compatible with laptop {self.manufacturer} {self.model}!"
            )

        if not 1 < ram <= Laptop.MAX_RAM or (ram & (ram - 1)) != 0: # checks if ram is ^2
            raise ValueError(
                f"{ram}GB RAM is not compatible with laptop {self.manufacturer} {self.model}!"
            )

        self.processor = processor
        self.ram = ram
        ram_price = int(math.log2(ram)) * 100 # log2() calculates the exponent
        self.price = Laptop.VALID_MODELS[processor] + ram_price

        return f"Created {self.manufacturer} {self.model} with {processor} and {ram}GB RAM for {self.price}$."
