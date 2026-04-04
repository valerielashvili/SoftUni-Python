from project.astronauts.base_astronaut import BaseAstronaut


class EngineerAstronaut(BaseAstronaut):
    SPECIALIZATION = "EngineerAstronaut"
    INITIAL_STAMINA = 80
    STAMINA_POINTS = 5

    def __init__(self, id_number: str, salary: float):
        super().__init__(id_number, salary, specialization=self.SPECIALIZATION, stamina=self.INITIAL_STAMINA)

    def train(self):
        future_stamina = self.stamina + self.STAMINA_POINTS

        if future_stamina > 100:
            self.stamina = 100
        else:
            self.stamina += self.STAMINA_POINTS
