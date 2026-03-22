class Cat:
  def __init__(self, name):
    self.name = name
    self.fed = False
    self.sleepy = False
    self.size = 0

  def eat(self):
    if self.fed:
      raise Exception('Already fed.')

    self.fed = True
    self.sleepy = True
    self.size += 1

  def sleep(self):
    if not self.fed:
      raise Exception('Cannot sleep while hungry')

    self.sleepy = False


from unittest import TestCase, main


class CatTests(TestCase):
    def test_cat_size_after_eat(self):
        cat = Cat('Nix')
        self.assertEqual(cat.size, 0)
        cat.eat()
        self.assertEqual(cat.size, 1)

    def test_is_fed_after_eat(self):
        cat = Cat('Nix')
        self.assertFalse(cat.fed, False)
        cat.eat()
        self.assertTrue(cat.fed, True)

    def test_already_fed_exception(self):
        cat = Cat('Nix')
        cat.eat()
        self.assertTrue(cat.fed, True)
        with self.assertRaises(Exception) as e:
            cat.eat()
        self.assertEqual('Already fed.', str(e.exception))

    def test_cannot_sleep_if_not_fed(self):
        cat = Cat('Nix')
        with self.assertRaises(Exception) as e:
            cat.sleep()
        self.assertEqual('Cannot sleep while hungry', str(e.exception))

    def test_not_sleepy_after_sleeping(self):
        cat = Cat('Nix')
        cat.eat(), cat.sleep()
        self.assertFalse(cat.sleepy, False)


if __name__ == '__main__':
    main()
