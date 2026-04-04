from unittest import TestCase, main
from project.star_system import StarSystem


class TestStarSystem(TestCase):
    STAR_TYPES = {'Red giant', 'Blue giant', 'Yellow dwarf', 'Red dwarf', 'Brown dwarf'}
    STAR_SYSTEM_TYPES = {'Single', 'Binary', 'Triple', 'Multiple'}

    def setUp(self):
        self.star_system = StarSystem(
            "Alpha",
            "Blue giant",
            "Binary",
            5,
            (0, 20)
        )

    def test_init_method(self):
        self.assertEqual(self.star_system.name, "Alpha")
        self.assertEqual(self.star_system.star_type, "Blue giant")
        self.assertEqual(self.star_system.system_type, "Binary")
        self.assertEqual(self.star_system.num_planets, 5)
        self.assertEqual(self.star_system.habitable_zone_range, (0, 20))

    def test_is_habitable_true(self):
        self.assertEqual(self.star_system.is_habitable, True)

    def test_is_habitable_both_properties_not_set(self):
        # Not habitable case
        self.star_system.habitable_zone_range = None
        self.star_system.num_planets = 0
        self.assertEqual(self.star_system.is_habitable, False)

    def test_is_habitable_habitable_zone_range_not_set(self):
        # Not habitable case
        self.star_system.habitable_zone_range = None
        self.assertEqual(self.star_system.is_habitable, False)

    def test_is_habitable_num_planets_is_zero(self):
        # Not habitable case
        self.star_system.num_planets = 0
        self.assertEqual(self.star_system.is_habitable, False)

    def test_name_setter(self):
        self.star_system.name = "Earth"
        self.assertEqual(self.star_system.name, "Earth")

        # Exception case
        with self.assertRaises(ValueError) as e:
            self.star_system.name = ""
        self.assertEqual(str(e.exception), "Name must be a non-empty string.")

    def test_star_type_setter(self):
        self.star_system.star_type = "Red giant"
        self.assertEqual(self.star_system.star_type, "Red giant")

        # Exception case
        with self.assertRaises(ValueError) as e:
            self.star_system.star_type = "Blabla"
        self.assertEqual(str(e.exception), f"Star type must be one of {sorted(self.STAR_TYPES)}.")

    def test_system_type_setter(self):
        self.star_system.system_type = "Single"
        self.assertEqual(self.star_system.system_type, "Single")

        # Exception case
        with self.assertRaises(ValueError) as e:
            self.star_system.system_type = "Blabla"
        self.assertEqual(str(e.exception), f"System type must be one of {sorted(self.STAR_SYSTEM_TYPES)}.")

    def test_num_planets_setter(self):
        self.star_system.num_planets = 6
        self.assertEqual(self.star_system.num_planets, 6)

        # Exception case
        with self.assertRaises(ValueError) as e:
            self.star_system.num_planets = -1
        self.assertEqual(str(e.exception), "Number of planets must be a non-negative integer.")

    def test_habitable_zone_range_setter(self):
        self.star_system.habitable_zone_range = (0, 10)
        self.assertEqual(self.star_system.habitable_zone_range, (0, 10))

        # Exception case: range len exceeded
        with self.assertRaises(ValueError) as e:
            self.star_system.habitable_zone_range = (0, 10, 20)
        self.assertEqual(
            str(e.exception),
            "Habitable zone range must be a tuple of two numbers (start, end) where start < end."
        )

        # Exception case: start < end
        with self.assertRaises(ValueError) as e:
            self.star_system.habitable_zone_range = (10, 0)
        self.assertEqual(
            str(e.exception),
            "Habitable zone range must be a tuple of two numbers (start, end) where start < end."
        )

    def test_greater_override_method_exception_self_not_habitable(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 50)
        )

        self.star_system.habitable_zone_range = None
        self.star_system.num_planets = 0
        expected_result = "Comparison not possible: One or both systems lack a defined habitable zone or planets."

        with self.assertRaises(ValueError) as e:
            result = self.star_system > self.triple_system
        self.assertTrue(
            str(e.exception),
            expected_result
        )

    def test_greater_override_method_exception_other_not_habitable(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 50)
        )

        self.triple_system.habitable_zone_range = None
        self.triple_system.num_planets = 0
        expected_result = "Comparison not possible: One or both systems lack a defined habitable zone or planets."

        with self.assertRaises(ValueError) as e:
            result = self.star_system > self.triple_system
        self.assertTrue(
            str(e.exception),
            expected_result
        )

    def test_greater_override_method_exception_both_not_habitable(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 50)
        )
        self.triple_system.habitable_zone_range = None
        self.triple_system.num_planets = 0
        self.star_system.habitable_zone_range = None
        self.star_system.num_planets = 0
        expected_result = "Comparison not possible: One or both systems lack a defined habitable zone or planets."

        with self.assertRaises(ValueError) as e:
            result = self.star_system > self.triple_system
        self.assertTrue(
            str(e.exception),
            expected_result
        )

    def test_greater_override_method_self_greater(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 5)
        )

        self.assertTrue(self.star_system > self.triple_system)

    def test_greater_override_method_other_greater(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 50)
        )

        self.assertTrue(self.star_system < self.triple_system)

    def test_compare_star_systems_self_greater_message(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            3,
            (0, 5)
        )
        result = self.star_system.compare_star_systems(self.star_system, self.triple_system)
        self.assertEqual(
            result,
            f"{self.star_system.name} has a wider habitable zone than {self.triple_system.name}."
        )

    def test_compare_star_systems_self_greater_exception(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            0,
            None
        )
        result = self.star_system.compare_star_systems(self.star_system, self.triple_system)
        self.assertEqual(
            result,
            "Comparison not possible: One or both systems lack a defined habitable zone or planets."
        )

    def test_compare_star_systems_other_greater_message(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 50)
        )
        result = self.star_system.compare_star_systems(self.star_system, self.triple_system)
        self.assertEqual(
            result,
            f"{self.triple_system.name} has a wider or equal habitable zone compared to {self.star_system.name}."
        )

    def test_compare_star_systems_other_greater_exception(self):
        self.triple_system = StarSystem(
            "Beta",
            "Red giant",
            "Triple",
            10,
            (0, 50)
        )
        self.star_system.num_planets = 0
        self.star_system.habitable_zone_range = None

        result = self.star_system.compare_star_systems(self.star_system, self.triple_system)
        self.assertEqual(
            result,
            "Comparison not possible: One or both systems lack a defined habitable zone or planets."
        )


if __name__ == '__main__':
    main()
