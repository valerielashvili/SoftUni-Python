class IntegerList:
    def __init__(self, *args):
        self.__data = []
        for x in args:
            if type(x) == int:
                self.__data.append(x)

    def get_data(self):
        return self.__data

    def add(self, element):
        if not type(element) == int:
            raise ValueError("Element is not Integer")
        self.get_data().append(element)
        return self.get_data()

    def remove_index(self, index):
        if index >= len(self.get_data()):
            raise IndexError("Index is out of range")
        a = self.get_data()[index]
        del self.get_data()[index]
        return a

    def get(self, index):
        if index >= len(self.get_data()):
            raise IndexError("Index is out of range")
        return self.get_data()[index]

    def insert(self, index, el):
        if index >= len(self.get_data()):
            raise IndexError("Index is out of range")
        elif not type(el) == int:
            raise ValueError("Element is not Integer")

        self.get_data().insert(index, el)

    def get_biggest(self):
        a = sorted(self.get_data(), reverse=True)
        return a[0]

    def get_index(self, el):
        return self.get_data().index(el)


from unittest import TestCase, main


class IntegerListTests(TestCase):
    def test_init(self):
        int_list = IntegerList(1, 5, 7.4)
        for element in int_list.get_data():
            self.assertIsInstance(element, int)

    def test_integer_addition(self):
        int_list = IntegerList(1, 5)
        self.assertIsInstance(int_list.add(7), list)

        with self.assertRaises(ValueError) as e:
            int_list.add("Knock!")
        self.assertEqual("Element is not Integer", str(e.exception))

    def test_remove_index(self):
        int_list = IntegerList(1, 5)
        self.assertEqual(int_list.remove_index(0), 1)

        with self.assertRaises(IndexError) as e:
            int_list.remove_index(5)
        self.assertEqual("Index is out of range", str(e.exception))

    def test_get_returns_element(self):
        int_list = IntegerList(1, 5, 7)
        self.assertEqual(int_list.get(0), 1)

        with self.assertRaises(IndexError) as e:
            int_list.get(3)
        self.assertEqual("Index is out of range", str(e.exception))

    def test_insert(self):
        int_list = IntegerList(1, 5, 7)
        self.assertEqual(len(int_list.get_data()), 3)
        int_list.insert(2, 9)
        self.assertEqual(len(int_list.get_data()), 4)

        with self.assertRaises(IndexError) as e:
            int_list.insert(4, 11)
        self.assertEqual("Index is out of range", str(e.exception))

        with self.assertRaises(ValueError) as e:
            int_list.insert(0, False)
        self.assertEqual("Element is not Integer", str(e.exception))

    def test_get_biggest(self):
        int_list = IntegerList(1, 5, 7)
        self.assertEqual(int_list.get_biggest(), 7)

    def test_get_index(self):
        int_list = IntegerList(1, 5, 7)
        self.assertEqual(int_list.get_index(7), 2)


if __name__ == '__main__':
    main()
