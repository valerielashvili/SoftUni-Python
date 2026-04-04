from project.astronauts.base_astronaut import BaseAstronaut


class ScientistAstronaut(BaseAstronaut):
    SPECIALIZATION = "ScientistAstronaut"
    INITIAL_STAMINA = 70
    STAMINA_POINTS = 3

    def __init__(self, id_number: str, salary: float):
        super().__init__(id_number, salary, specialization=self.SPECIALIZATION, stamina=self.INITIAL_STAMINA)

    def train(self):
        future_stamina = self.stamina + self.STAMINA_POINTS

        if future_stamina > 100:
            self.stamina = 100
        else:
            self.stamina += self.STAMINA_POINTS
