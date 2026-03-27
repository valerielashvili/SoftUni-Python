from unittest import TestCase, main
from project.soccer_player import SoccerPlayer

class TestSoccerPlayer(TestCase):
    def setUp(self):
        self.player1 = SoccerPlayer("Alexander", 28, 45, "Barcelona")
        self.player2 = SoccerPlayer("Peter", 20, 20, "Barcelona")

    def test_class_attribute_type(self):
        self.assertIsInstance(SoccerPlayer._VALID_TEAMS, list)

    def test_constructor(self):
        self.assertEqual(self.player1.name, "Alexander")
        self.assertEqual(self.player1.age, 28)
        self.assertEqual(self.player1.goals, 45)
        self.assertEqual(self.player1.team, "Barcelona")

    def test_name_property(self):
        with self.assertRaises(ValueError) as e:
            self.player1.name = "Bob"
        self.assertEqual("Name should be more than 5 symbols!", str(e.exception))
        self.assertEqual(self.player1.name, "Alexander")

    def test_age_property(self):
        with self.assertRaises(ValueError) as e:
            self.player1.age = 15
        self.assertEqual("Players must be at least 16 years of age!", str(e.exception))
        self.assertEqual(self.player1.age, 28)

    def test_goals_property(self):
        self.player1.goals = -1
        self.assertEqual(self.player1.goals, 0)
        self.player1.goals = 2
        self.assertEqual(self.player1.goals, 2)

    def test_team_property(self):
        with self.assertRaises(ValueError) as e:
            self.player1.team = "Real Gamadrid"
        self.assertEqual(
            f"Team must be one of the following: {', '.join(SoccerPlayer._VALID_TEAMS)}!",
            str(e.exception)
        )

    def test_change_team_method(self):
        with self.assertRaises(ValueError) as e:
            self.player1.change_team("Real Gamadrid")
        self.assertEqual("Invalid team name!", str(e.exception))

        team_changed = self.player1.change_team("Manchester United")
        self.assertEqual(team_changed, "Manchester United")

    def test_add_new_achievement(self):
        self.player1.add_new_achievement("World Cup")
        self.assertEqual(self.player1.achievements["World Cup"], 0)
        self.player1.add_new_achievement("World Cup")
        self.assertEqual(self.player1.achievements["World Cup"], 1)

    def test_less_than_magic_method(self):
        self.assertLess(
            self.player2 < self.player1,
        f"{self.player2.name} is a top goal scorer! S/he scored more than {self.player1.name}."
        )

        self.assertLess(
            self.player1 < self.player2,
        f"{self.player1.name} is a better goal scorer than {self.player2.name}."
        )
