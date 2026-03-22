import unittest


class Car:
    def __init__(self, make, model, fuel_consumption, fuel_capacity):
        self.make = make
        self.model = model
        self.fuel_consumption = fuel_consumption
        self.fuel_capacity = fuel_capacity
        self.fuel_amount = 0

    @property
    def make(self):
        return self.__make

    @make.setter
    def make(self, new_value):
        if not new_value:
            raise Exception("Make cannot be null or empty!")
        self.__make = new_value

    @property
    def model(self):
        return self.__model

    @model.setter
    def model(self, new_value):
        if not new_value:
            raise Exception("Model cannot be null or empty!")
        self.__model = new_value

    @property
    def fuel_consumption(self):
        return self.__fuel_consumption

    @fuel_consumption.setter
    def fuel_consumption(self, new_value):
        if new_value <= 0:
            raise Exception("Fuel consumption cannot be zero or negative!")
        self.__fuel_consumption = new_value

    @property
    def fuel_capacity(self):
        return self.__fuel_capacity

    @fuel_capacity.setter
    def fuel_capacity(self, new_value):
        if new_value <= 0:
            raise Exception("Fuel capacity cannot be zero or negative!")
        self.__fuel_capacity = new_value

    @property
    def fuel_amount(self):
        return self.__fuel_amount

    @fuel_amount.setter
    def fuel_amount(self, new_value):
        if new_value < 0:
            raise Exception("Fuel amount cannot be negative!")
        self.__fuel_amount = new_value

    def refuel(self, fuel):
        if fuel <= 0:
            raise Exception("Fuel amount cannot be zero or negative!")
        self.__fuel_amount += fuel
        if self.__fuel_amount > self.__fuel_capacity:
            self.__fuel_amount = self.__fuel_capacity

    def drive(self, distance):
        needed = (distance / 100) * self.__fuel_consumption

        if needed > self.__fuel_amount:
            raise Exception("You don't have enough fuel to drive!")

        self.__fuel_amount -= needed


from unittest import TestCase, main


class CarTests(TestCase):
    def test_car_init(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.make, "BMW")
        self.assertEqual(car.model, "X3")
        self.assertEqual(car.fuel_consumption, 10)
        self.assertEqual(car.fuel_capacity, 65)
        self.assertEqual(car.fuel_amount, 0)

    def test_make_setter(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.make, "BMW")

        with self.assertRaises(Exception) as e:
            car.make = ""
        self.assertEqual("Make cannot be null or empty!", str(e.exception))

        car.make = "Mercedes"
        self.assertEqual(car.make, "Mercedes")

    def test_model_setter(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.model, "X3")

        with self.assertRaises(Exception) as e:
            car.model = ""
        self.assertEqual("Model cannot be null or empty!", str(e.exception))

        car.model = "X5"
        self.assertEqual(car.model, "X5")

    def test_fuel_consumption_setter(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.fuel_consumption, 10)

        with self.assertRaises(Exception) as e:
            car.fuel_consumption = 0
        self.assertEqual("Fuel consumption cannot be zero or negative!", str(e.exception))

        with self.assertRaises(Exception) as e:
            car.fuel_consumption = -1
        self.assertEqual("Fuel consumption cannot be zero or negative!", str(e.exception))

        car.fuel_consumption = 12
        self.assertEqual(car.fuel_consumption, 12)

    def test_fuel_capacity_setter(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.fuel_capacity, 65)

        with self.assertRaises(Exception) as e:
            car.fuel_capacity = 0
        self.assertEqual("Fuel capacity cannot be zero or negative!", str(e.exception))

        with self.assertRaises(Exception) as e:
            car.fuel_capacity = -1
        self.assertEqual("Fuel capacity cannot be zero or negative!", str(e.exception))

        car.fuel_capacity = 70
        self.assertEqual(car.fuel_capacity, 70)

    def test_fuel_amount_setter(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.fuel_amount, 0)

        with self.assertRaises(Exception) as e:
            car.fuel_amount = -1
        self.assertEqual("Fuel amount cannot be negative!", str(e.exception))

        car.fuel_amount = 70
        self.assertEqual(car.fuel_amount, 70)

    def test_refuel(self):
        car = Car("BMW", "X3", 10, 65)
        self.assertEqual(car.fuel_amount, 0)

        with self.assertRaises(Exception) as e:
            car.refuel(0)
        self.assertEqual("Fuel amount cannot be zero or negative!", str(e.exception))

        with self.assertRaises(Exception) as e:
            car.refuel(-1)
        self.assertEqual("Fuel amount cannot be zero or negative!", str(e.exception))

        car.refuel(70)
        self.assertEqual(car.fuel_amount, 65)

    def test_drive(self):
        car = Car("BMW", "X3", 10, 65)

        with self.assertRaises(Exception) as e:
            car.drive(30)
        self.assertEqual("You don't have enough fuel to drive!", str(e.exception))

        car.refuel(65)
        car.drive(30)
        self.assertEqual(car.fuel_amount, 62)


if __name__ == '__main__':
    main()
