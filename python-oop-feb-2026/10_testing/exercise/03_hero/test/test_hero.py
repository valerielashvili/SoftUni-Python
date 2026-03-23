from unittest import TestCase, main
from project.hero import Hero


class HeroTest(TestCase):
    username = "Harbinger"
    level = 7
    health = 34.5
    damage = 24.3

    def setUp(self):
        self.hero = Hero(self.username, self.level, self.health, self.damage)
        self.enemy = Hero("Prophet", self.level, self.health, self.damage)

    def test_attr_types(self):
        self.assertIsInstance(self.hero.username, str)
        self.assertIsInstance(self.hero.level, int)
        self.assertIsInstance(self.hero.health, float)
        self.assertIsInstance(self.hero.damage, float)

    def test_init(self):
        self.assertEqual(self.hero.username, self.username)
        self.assertEqual(self.hero.level, self.level)
        self.assertEqual(self.hero.health, self.health)
        self.assertEqual(self.hero.damage, self.damage)

    def test_enemy_names(self):
        self.enemy.username = self.username

        with self.assertRaises(Exception) as e:
            self.hero.battle(self.enemy)
        self.assertEqual("You cannot fight yourself", str(e.exception))

    def test_hero_health_logic(self):
        self.hero.health = 0

        with self.assertRaises(ValueError) as e:
            self.hero.battle(self.enemy)
        self.assertEqual("Your health is lower than or equal to 0. You need to rest", str(e.exception))

        self.hero.health = -1
        with self.assertRaises(ValueError) as e:
            self.hero.battle(self.enemy)
        self.assertEqual("Your health is lower than or equal to 0. You need to rest", str(e.exception))

    def test_enemy_health_logic(self):
        self.enemy.health = 0

        with self.assertRaises(ValueError) as e:
            self.hero.battle(self.enemy)
        self.assertEqual(f"You cannot fight {self.enemy.username}. He needs to rest", str(e.exception))

        self.enemy.health = -1
        with self.assertRaises(ValueError) as e:
            self.hero.battle(self.enemy)
        self.assertEqual(f"You cannot fight {self.enemy.username}. He needs to rest", str(e.exception))

    def test_draw(self):
        battle_result = self.hero.battle(self.enemy)
        self.assertEqual(battle_result, "Draw")
        self.assertEqual(self.hero.level, self.level)
        self.assertEqual(self.hero.health, -135.6)
        self.assertEqual(self.hero.damage, self.damage)

    def test_hero_win(self):
        self.enemy.level, self.enemy.health, self.enemy.damage = 1, 1, 1
        battle_result = self.hero.battle(self.enemy)

        self.assertEqual(battle_result, "You win")
        self.assertEqual(self.hero.level, 8)
        self.assertEqual(self.hero.health, 38.5)
        self.assertEqual(self.hero.damage, 29.3)

    def test_hero_loss(self):
        self.hero.level, self.hero.health, self.hero.damage = 1, 1, 1
        battle_result = self.hero.battle(self.enemy)

        self.assertEqual(battle_result, "You lose")
        self.assertEqual(self.enemy.level, 8)
        self.assertEqual(self.enemy.health, 38.5)
        self.assertEqual(self.enemy.damage, 29.3)

    def test_str(self):
        expected_str = f"Hero {self.username}: {self.level} lvl\n" \
                          f"Health: {self.health}\n" \
                          f"Damage: {self.damage}\n"
        actual_str = str(self.hero)
        self.assertEqual(expected_str, actual_str)


if __name__ == "__main__":
    main()
