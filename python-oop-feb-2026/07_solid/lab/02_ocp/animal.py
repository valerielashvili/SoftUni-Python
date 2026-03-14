"""Open-Closed Principle"""

from abc import ABC, abstractmethod


class Animal(ABC):
    @abstractmethod
    def make_sound(self):
        pass


class Dog(Animal):
    def make_sound(self):
        return "woof-woof"


class Cat(Animal):
    def make_sound(self):
        return "meow"


class Chicken(Animal):
    def make_sound(self):
        return "clunk"


# animal_sound function is closed for modification,
# but the classes are open for extension
def animal_sound(animals: list):
    for animal in animals:
        print(animal.make_sound())

# Test code
animals = [Dog, Cat, Chicken]
animal_sound(animals)
