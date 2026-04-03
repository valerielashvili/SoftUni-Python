from unittest import TestCase, main
from project.trip import Trip


class TestTrip(TestCase):
    DESTINATION_PRICES_PER_PERSON = {'New Zealand': 7500, 'Australia': 5700, 'Brazil': 6200, 'Bulgaria': 500}

    def setUp(self):
        self.trip = Trip(8000, 1, False)

    # Optional
    def test_trip_structure(self):
        self.assertEqual(Trip.__base__.__name__, "object")
        self.assertTrue(isinstance(getattr(Trip, "travelers"), property))
        self.assertTrue(isinstance(getattr(Trip, "is_family"), property))
        self.assertTrue(hasattr(Trip, "book_a_trip"))
        self.assertTrue(hasattr(Trip, "booking_status"))

    def test_init_method(self):
        self.assertEqual(self.trip.budget, 8000)
        self.assertEqual(self.trip.travelers, 1)
        self.assertEqual(self.trip.is_family, False)
        self.assertEqual(self.trip.booked_destinations_paid_amounts, {})

    def test_travelers_setter_exception(self):
        with self.assertRaises(ValueError) as e:
            self.trip.travelers = 0
        self.assertEqual(str(e.exception), "At least one traveler is required!")

    def test_travelers_setter(self):
        self.trip.travelers = 1
        self.assertEqual(self.trip.travelers, 1)

    def test_is_family_not_enough_members(self):
        self.trip.is_family = True
        self.assertEqual(self.trip.is_family, False)

    def test_is_family_enough_members(self):
        self.trip.travelers = 2
        self.trip.is_family = True
        self.assertEqual(self.trip.is_family, True)

    def test_book_a_trip_wrong_destination(self):
        result = self.trip.book_a_trip("Peru")
        self.assertEqual(result, "This destination is not in our offers, please choose a new one!")

    def test_book_a_trip_correct_destination_family_price_no_budget(self):
        destination = "Australia"
        discount = 0.9
        self.trip.travelers = 2
        self.trip.is_family = True
        self.trip.budget = 500
        result = self.trip.book_a_trip(destination)
        self.assertEqual(result, "Your budget is not enough!")

        required_price = self.DESTINATION_PRICES_PER_PERSON[destination] * self.trip.travelers
        required_price *= discount
        self.assertLess(self.trip.budget, required_price)

    def test_book_a_trip_correct_destination_solo_price_no_budget(self):
        destination = "Australia"
        self.trip.travelers = 1
        self.trip.budget = 500
        result = self.trip.book_a_trip(destination)
        self.assertEqual(result, "Your budget is not enough!")

        required_price = self.DESTINATION_PRICES_PER_PERSON[destination] * self.trip.travelers
        self.assertLess(self.trip.budget, required_price)

    def test_book_a_trip_correct_destination(self):
        destination = "New Zealand"
        required_price = self.DESTINATION_PRICES_PER_PERSON[destination] * self.trip.travelers
        result = self.trip.book_a_trip(destination)

        self.assertEqual(self.trip.booked_destinations_paid_amounts[destination], required_price)
        self.assertEqual(self.trip.budget, 500)
        self.assertEqual(result, f"Successfully booked destination {destination}! Your budget left is {500:.2f}")

    def test_booking_status_no_trips(self):
        result = self.trip.booking_status()
        self.assertEqual(result, f"No bookings yet. Budget: {self.trip.budget:.2f}")

    def test_booking_status(self):
        self.trip.budget = 8000
        self.trip.book_a_trip("New Zealand")
        self.trip.book_a_trip("Bulgaria")

        self.assertEqual(len(self.trip.booked_destinations_paid_amounts), 2)
        self.assertIn("New Zealand", self.trip.booked_destinations_paid_amounts)
        self.assertIn("Bulgaria", self.trip.booked_destinations_paid_amounts)
        self.assertEqual(self.trip.booked_destinations_paid_amounts["New Zealand"], 7500)
        self.assertEqual(self.trip.booked_destinations_paid_amounts["Bulgaria"], 500)

        expected_result = (
            "Booked Destination: Bulgaria\n"
            f"Paid Amount: {500:.2f}\n"
            "Booked Destination: New Zealand\n"
            f"Paid Amount: {7500:.2f}\n"
            f"Number of Travelers: {self.trip.travelers}\n"
            f"Budget Left: {0:.2f}"
        )
        result = self.trip.booking_status()
        self.assertEqual(result, expected_result)


if __name__ == "__main__":
    main()
