"""Liskov Substitution Principle"""

from abc import ABC


class Toy(ABC):
    """Class Duck refactored to Toy"""
    @staticmethod
    def quack():
        pass

    @staticmethod
    def walk():
        pass

    @staticmethod
    def fly():
        pass


class RobotDuck(Toy):
    HEIGHT = 50

    def __init__(self):
        self.height = 0

    @staticmethod
    def quack():
        return 'Robotic quacking'

    @staticmethod
    def walk():
        return 'Robotic walking'

    def fly(self):
        """can only fly to specific height but
        when it reaches it starts landing automatically"""
        if self.height == RobotDuck.HEIGHT:
            self.land()
        else:
            self.height += 1

    def land(self):
        self.height = 0
