from unittest import TestCase, main
from project.vehicle import Vehicle


class VehicleTests(TestCase):
    fuel = 65
    horse_power = 245

    def setUp(self):
        self.vehicle = Vehicle(self.fuel, self.horse_power)

    def test_class_attributes_types(self):
        self.assertTrue(self.vehicle.DEFAULT_FUEL_CONSUMPTION, float)
        self.assertTrue(self.vehicle.fuel_consumption, float)
        self.assertTrue(self.vehicle.fuel, float)
        self.assertTrue(self.vehicle.capacity, float)
        self.assertTrue(self.vehicle.horse_power, float)

    def test_init(self):
        self.assertEqual(self.vehicle.fuel, self.fuel)
        self.assertEqual(self.vehicle.capacity, self.fuel)
        self.assertEqual(self.vehicle.horse_power, self.horse_power)
        self.assertEqual(self.vehicle.fuel_consumption, self.vehicle.DEFAULT_FUEL_CONSUMPTION)

    def test_drive(self):
        with self.assertRaises(Exception) as e:
            self.vehicle.drive(70)
        self.assertEqual("Not enough fuel", str(e.exception))

        self.vehicle.drive(30)
        self.assertEqual(self.vehicle.fuel, 27.5)

    def test_refuel(self):
        with self.assertRaises(Exception) as e:
            self.vehicle.refuel(70)
        self.assertEqual("Too much fuel", str(e.exception))

        self.vehicle.drive(30)
        self.vehicle.refuel(20)
        self.assertEqual(self.vehicle.fuel, 47.5)

    def test_vehicle_str_representation(self):
        string = self.vehicle.__str__()
        self.assertEqual(
            string,
            "The vehicle has 245 horse power with 65 fuel left and 1.25 fuel consumption"
        )


if __name__ == "__main__":
    main()
