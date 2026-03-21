import math
from project.computer_types.computer import Computer


class DesktopComputer(Computer):
    VALID_MODELS = {
        "AMD Ryzen 7 5700G": 500,
        "Intel Core i5-12600K": 600,
        "Apple M1 Max": 1800
    }
    MAX_RAM = 128

    def __init__(self, manufacturer: str, model: str):
        super().__init__(manufacturer, model)

    def configure_computer(self, processor: str, ram: int):
        if processor not in DesktopComputer.VALID_MODELS:
            raise ValueError(
                f"{processor} is not compatible with desktop computer {self.manufacturer} {self.model}!"
            )

        if not 1 < ram <= DesktopComputer.MAX_RAM or (ram & (ram - 1)) != 0: # checks if ram is ^2
            raise ValueError(
                f"{ram}GB RAM is not compatible with desktop computer {self.manufacturer} {self.model}!"
            )

        self.processor = processor
        self.ram = ram
        ram_price = int(math.log2(ram)) * 100 # log2() calculates the exponent
        self.price = DesktopComputer.VALID_MODELS[processor] + ram_price

        return f"Created {self.manufacturer} {self.model} with {processor} and {ram}GB RAM for {self.price}$."
