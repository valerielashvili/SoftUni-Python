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
        if self.__budget - price > 0 and len(self.animals) < self.__animal_capacity:
            self.animals.append(animal)
            self.__budget -= price
            return f"{animal.name} the {type(animal).__name__} added to the zoo"

        elif self.__budget - price < 0 and len(self.animals) <= self.__animal_capacity:
            return "Not enough budget"
        else:
            return "Not enough space for animal"

    def hire_worker(self, worker: Keeper | Caretaker | Vet):
        if len(self.workers) < self.__workers_capacity:
            self.workers.append(worker)
            return f"{worker.name} the {type(worker).__name__} hired successfully"
        else:
            return "Not enough space for worker"

    def fire_worker(self, worker_name):
        if any(w.name == worker_name for w in self.workers):
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
        groups = {
            f"{cls.__name__}s": [a for a in self.animals if isinstance(a, cls)]
            for cls in (Lion, Tiger, Cheetah)
        }

        output = f"You have {len(self.animals)} animals"

        for animal_cls in ('Lions', 'Tigers', 'Cheetahs'):
            output += f"\n----- {len(groups[animal_cls])} {animal_cls}:\n"
            output += '\n'.join(a.__repr__() for a in groups[animal_cls])

        return output

    def workers_status(self):
        groups = {
            f"{cls.__name__}s": [a for a in self.workers if isinstance(a, cls)]
            for cls in (Keeper, Caretaker, Vet)
        }

        output = f"You have {len(self.workers)} workers"

        for worker_cls in ('Keepers', 'Caretakers', 'Vets'):
            output += f"\n----- {len(groups[worker_cls])} {worker_cls}:\n"
            output += '\n'.join(w.__repr__() for w in groups[worker_cls])

        return output
