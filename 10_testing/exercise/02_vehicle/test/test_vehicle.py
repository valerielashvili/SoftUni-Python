from unittest import TestCase, main
from project.vehicle import Vehicle


class VehicleTests(TestCase):
    def setUp(self):
        self.vehicle = Vehicle(65, 245)

    def test_init(self):
        self.assertEqual(self.vehicle.fuel, 65)
        self.assertEqual(self.vehicle.capacity, 65)
        self.assertEqual(self.vehicle.horse_power, 245)
        self.assertEqual(self.vehicle.fuel_consumption, 1.25)

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
