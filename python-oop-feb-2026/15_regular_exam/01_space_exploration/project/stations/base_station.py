from abc import ABC, abstractmethod


class BaseStation(ABC):
    def __init__(self, name: str, capacity: int):
        self.name = name
        self.capacity = capacity
        self.astronauts: list = []

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, value: str):
        if not value.isalnum() and "-" not in value:
            raise ValueError("Station names can contain only letters, numbers, and hyphens!")
        self.__name = value

    @property
    def capacity(self):
        return self.__capacity

    @capacity.setter
    def capacity(self, value: int):
        if value < 0:
            raise ValueError("A station cannot have a negative capacity!")
        self.__capacity = value

    def calculate_total_salaries(self):
        total_salaries = sum(a.salary for a in self.astronauts)
        return f"{total_salaries:.2f}"

    def status(self):
        astronauts_sorted = sorted(self.astronauts, key=lambda a: a.id_number)

        status = f"Station name: {self.name}; Astronauts: "

        if astronauts_sorted:
            status += ' #'.join(a.id_number for a in astronauts_sorted)
        else:
            status += "N/A"

        status += f"; Total salaries: {self.calculate_total_salaries()}"

        return status

    @abstractmethod
    def update_salaries(self, min_value: float):
        pass
