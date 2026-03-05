from lion import Lion
from cheetah import Cheetah
from tiger import Tiger
from keeper import Keeper
from caretaker import Caretaker
from vet import Vet


class Zoo:
    def __init__(self, name: str, budget: int, animal_capacity: int, workers_capacity: int):
        self.name = name
        self.__budget = budget
        self.__animal_capacity = animal_capacity
        self.__workers_capacity = workers_capacity
        self.animals = []
        self.workers = []

    def add_animal(self, animal, price):
        if (
                self.__budget > 0 and
                len(self.animals) < self.__animal_capacity and
                len(self.workers) < self.__workers_capacity
        ):
            self.animals.append(animal)
            self.__budget -= price
        elif self.__budget <= 0 < self.__animal_capacity and self.__workers_capacity > 0:
            return "Not enough budget"
        else:
            return "Not enough space for animal"

    def hire_worker(self, worker: Keeper | Caretaker | Vet):
        if len(self.workers) < self.__workers_capacity:
            self.workers.append(worker)
            return f"{worker.name} the {type(worker)} hired successfully"
        else:
            return "Not enough space for worker"

    def fire_worker(self, worker_name):
        if any(w == worker_name for w in self.workers):
            filtered_workers = list(filter(lambda w: w.name != worker_name, self.workers))
            self.workers = filtered_workers
            return f"{worker_name} fired successfully"
        else:
            return f"There is no {worker_name} in the zoo"

    def pay_workers(self):
        total_salaries = sum(w.salary for w in self.workers)

        if self.__budget >= total_salaries:
            salary_to_pay = self.__budget / len(self.workers)

            for worker in self.workers:
                worker.salary += salary_to_pay
            self.__budget -= total_salaries

            return f"You payed your workers. They are happy. Budget left: {self.__budget}"
        else:
            return "You have no budget to pay your workers. They are unhappy"

    def tend_animals(self):
        animal_expenses = sum(a.MONEY_FOR_CARE for a in self.animals)
        if self.__budget >= animal_expenses:
            self.__budget -= animal_expenses
            return f"You tended all the animals. They are happy. Budget left: {self.__budget}"
        else:
            return "You have no budget to tend the animals. They are unhappy."

    def profit(self, amount):
        self.__budget += amount

    def animals_status(self):
        output = ""
        lions = list(filter(lambda c: type(c) == Lion, self.animals))
        tigers = list(filter(lambda c: type(c) == Tiger, self.animals))
        cheetahs = list(filter(lambda c: type(c) == Cheetah, self.animals))
        output += f"You have {len(self.animals)} animals\n"

        output += f"----- {len(lions)} Lions:\n"
        for lion in lions:
            output += f"{lion.__repr__()}\n"

        output += f"----- {len(tigers)} Tigers:\n"
        for tiger in tigers:
            output += f"{tiger.__repr__()}\n"

        output += f"----- {len(cheetahs)} Cheetahs:\n"
        for cheetah in cheetahs:
            output += f"{cheetah.__repr__()}\n"

        return output
