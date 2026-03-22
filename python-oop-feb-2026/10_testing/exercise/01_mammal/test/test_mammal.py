from unittest import TestCase, main
from project.mammal import Mammal

class MammalTests(TestCase):
    def setUp(self):
        self.mammal = Mammal("Mammal", "Marsupials", "Wuaaa!")

    def test_init(self):
        self.assertEqual(self.mammal.name, "Mammal")
        self.assertEqual(self.mammal.type, "Marsupials")
        self.assertEqual(self.mammal.sound, "Wuaaa!")

    def test_make_sound(self):
        self.assertEqual(self.mammal.make_sound(), "Mammal makes Wuaaa!")

    def test_get_kingdom(self):
        self.assertEqual(self.mammal.get_kingdom(), "animals")

    def test_info(self):
        self.assertEqual(self.mammal.info(), "Mammal is of type Marsupials")


if __name__ == "__main__":
    main()
