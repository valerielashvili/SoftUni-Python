from unittest import TestCase, main
from project.furniture import Furniture


class TestFurniture(TestCase):
    def setUp(self):
        self.table = Furniture(
            "Kitchen Table",
            155.5,
            (25, 100, 80),
            True,
            54
        )

    def test_init(self):
        self.assertEqual(self.table.model, "Kitchen Table")
        self.assertEqual(self.table.price, 155.5)
        self.assertEqual(self.table.dimensions, (25, 100, 80))
        self.assertTrue(self.table.in_stock)
        self.assertEqual(self.table.weight, 54)

    def test_model_setter(self):
        error_message = "Model must be a non-empty string with a maximum length of 50 characters."
        with self.assertRaises(ValueError) as e:
            self.table.model = ""

        self.assertEqual(error_message, str(e.exception))

        with self.assertRaises(ValueError) as e:
            self.table.model = "Some lengthy string to test 50 chars limit for model value"

        self.assertEqual(error_message, str(e.exception))

    def test_price_setter(self):
        with self.assertRaises(ValueError) as e:
            self.table.price = -1

        self.assertEqual("Price must be a non-negative number.", str(e.exception))

    def test_dimension_setter(self):
        with self.assertRaises(ValueError) as e:
            self.table.dimensions = (25, 100)

        self.assertEqual("Dimensions tuple must contain 3 integers.", str(e.exception))

        with self.assertRaises(ValueError) as e:
            self.table.dimensions = (-1, -2, -3)

        self.assertEqual("Dimensions tuple must contain integers greater than zero.", str(e.exception))

    def test_weight_setter(self):
        with self.assertRaises(ValueError) as e:
            self.table.weight = -1

        self.assertEqual("Weight must be greater than zero.", str(e.exception))

    def test_get_available_status_method(self):
        status = self.table.get_available_status()
        self.assertEqual(f"Model: {self.table.model} is currently in stock.", status)

        self.table.in_stock = False
        status = self.table.get_available_status()
        self.assertEqual(f"Model: {self.table.model} is currently unavailable.", status)

    def test_get_specifications_method(self):
        height, width, depth = self.table.dimensions
        specs = (f"Model: {self.table.model} has the following dimensions: "
                f"{height}mm x {width}mm x {depth}mm and weighs: {self.table.weight}")

        self.assertEqual(specs, self.table.get_specifications())


if __name__ == "__main__":
    main()
