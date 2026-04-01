from unittest import TestCase, main
from project.climbing_robot import ClimbingRobot


class TestClimbingRobot(TestCase):
    def setUp(self):
        self.ALLOWED_CATEGORIES = ['Mountain', 'Alpine', 'Indoor', 'Bouldering']
        self.robot = ClimbingRobot("Mountain", "Wheel", 4000, 2048)

    def test_climbing_robot_structure(self):
        self.assertEqual(ClimbingRobot.__base__.__name__, "object")
        self.assertTrue(hasattr(ClimbingRobot, "get_used_capacity"))
        self.assertTrue(hasattr(ClimbingRobot, "get_available_capacity"))
        self.assertTrue(hasattr(ClimbingRobot, "get_used_memory"))
        self.assertTrue(hasattr(ClimbingRobot, "get_available_memory"))
        self.assertTrue(hasattr(ClimbingRobot, "install_software"))

        self.assertTrue(isinstance(getattr(ClimbingRobot, "category"), property))

    def test_init_method(self):
        self.assertEqual(self.robot.category, "Mountain")
        self.assertEqual(self.robot.part_type, "Wheel")
        self.assertEqual(self.robot.capacity, 4000)
        self.assertEqual(self.robot.memory, 2048)
        self.assertIsInstance(self.robot.installed_software, list)
        self.assertEqual(self.robot.installed_software, [])

    def test_category_setter_valid(self):
        for category in self.ALLOWED_CATEGORIES:
            with self.subTest(category=category):
                self.robot.category = category
                self.assertEqual(self.robot.category, category)

    def test_category_setter(self):
        with self.assertRaises(ValueError) as e:
            self.robot.category = "None"
        self.assertEqual(str(e.exception), f"Category should be one of {self.ALLOWED_CATEGORIES}")

        self.robot.category = "Alpine"
        self.assertEqual(self.robot.category, "Alpine")

    def test_install_software(self):
        software = {
            "name": "Image Builder",
            "capacity_consumption": 65,
            "memory_consumption": 256
        }
        result = self.robot.install_software(software)
        self.assertEqual(
            result,
            f"Software '{software['name']}' successfully installed on {self.robot.category} part."
        )
        self.assertEqual(len(self.robot.installed_software), 1)
        self.assertIn(software, self.robot.installed_software)

    def test_install_software_memory_only_ok(self):
        software = {"name": "X", "capacity_consumption": 100, "memory_consumption": 50}
        self.robot.capacity = 50  # NOT enough
        self.robot.memory = 100  # enough

        result = self.robot.install_software(software)

        self.assertIn("cannot be installed", result)
        self.assertEqual(self.robot.installed_software, [])

    def test_install_software_capacity_only_ok(self):
        software = {"name": "X", "capacity_consumption": 100, "memory_consumption": 50}
        self.robot.capacity = 200  # enough
        self.robot.memory = 40  # NOT enough

        result = self.robot.install_software(software)

        self.assertIn("cannot be installed", result)
        self.assertEqual(self.robot.installed_software, [])

    def test_install_exact_fit(self):
        software = {"name": "X", "capacity_consumption": 100, "memory_consumption": 50}
        self.robot.capacity = 100
        self.robot.memory = 50

        result = self.robot.install_software(software)

        self.assertIn("successfully installed", result)

    def test_install_software_failure(self):
        software = {
            "name": "Space Trooper",
            "capacity_consumption": 5000,
            "memory_consumption": 2049
        }
        result = self.robot.install_software(software)
        self.assertEqual(
            result,
            f"Software '{software['name']}' cannot be installed on {self.robot.category} part."
        )
        self.assertEqual(self.robot.installed_software, [])

    def test_get_used_capacity(self):
        software = {
            "name": "Image Builder",
            "capacity_consumption": 65,
            "memory_consumption": 256
        }
        self.robot.install_software(software)
        used_capacity = self.robot.get_used_capacity()
        self.assertEqual(used_capacity, 65)

    def test_get_available_capacity(self):
        software = {
            "name": "Image Builder",
            "capacity_consumption": 500,
            "memory_consumption": 256
        }
        self.robot.install_software(software)
        available_capacity = self.robot.get_available_capacity()
        self.assertEqual(available_capacity, 3500)

    def test_get_used_memory(self):
        software = {
            "name": "Image Builder",
            "capacity_consumption": 500,
            "memory_consumption": 256
        }
        self.robot.install_software(software)
        used_memory = self.robot.get_used_memory()
        self.assertEqual(used_memory, 256)

    def test_get_available_memory(self):
        software = {
            "name": "Image Builder",
            "capacity_consumption": 500,
            "memory_consumption": 256
        }
        self.robot.install_software(software)
        available_memory = self.robot.get_available_memory()
        self.assertEqual(available_memory, 1792)


if __name__ == "__main__":
    main()
