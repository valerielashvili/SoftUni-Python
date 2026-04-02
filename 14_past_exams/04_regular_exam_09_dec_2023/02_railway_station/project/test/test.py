from collections import deque
from unittest import TestCase, main
from project.railway_station import RailwayStation


class TestRailwayStation(TestCase):
    def setUp(self) -> None:
        self.station = RailwayStation("Sofia")

    def test_railway_station_structure(self):
        self.assertEqual(RailwayStation.__base__.__name__, "object")
        self.assertTrue(isinstance(getattr(RailwayStation, "name"), property))
        self.assertTrue(hasattr(RailwayStation, "new_arrival_on_board"))
        self.assertTrue(hasattr(RailwayStation, "train_has_arrived"))
        self.assertTrue(hasattr(RailwayStation, "train_has_left"))

    def test_init_method(self):
        self.assertEqual(self.station.name, "Sofia")
        self.assertEqual(self.station.arrival_trains, deque())
        self.assertEqual(self.station.departure_trains, deque())

    def test_name_setter(self):
        with self.assertRaises(ValueError) as e:
            self.station.name = "xyz"
        self.assertEqual(str(e.exception), "Name should be more than 3 symbols!")

        self.station.name = "Varna"
        self.assertEqual(self.station.name, "Varna")

    def test_new_arrival_on_board_method(self):
        self.station.new_arrival_on_board("A")
        self.assertIn("A", self.station.arrival_trains)

    def test_train_has_arrived_method(self):
        train = "A"
        self.station.new_arrival_on_board(train)
        result = self.station.train_has_arrived(train)

        self.assertIn(train, self.station.departure_trains)
        self.assertEqual(result, f"{train} is on the platform and will leave in 5 minutes.")

    def test_train_has_arrived_with_no_trains(self):
        with self.assertRaises(IndexError) as e:
            self.station.train_has_arrived("A")

        self.assertEqual(str(e.exception), "pop from an empty deque")

    def test_train_has_arrived_multiple_trains(self):
        self.station.new_arrival_on_board("A")
        train = "High Speed Train"
        result = self.station.train_has_arrived(train)

        self.assertIn("A", self.station.arrival_trains)
        self.assertEqual(result, f"There are other trains to arrive before {train}.")

    def test_train_has_left(self):
        train = "A"
        self.station.new_arrival_on_board(train)
        self.station.train_has_arrived(train)
        self.assertTrue(self.station.train_has_left(train))
        self.assertEqual(self.station.departure_trains, deque())

        self.assertFalse(self.station.train_has_left("B"))


if __name__ == '__main__':
    main()