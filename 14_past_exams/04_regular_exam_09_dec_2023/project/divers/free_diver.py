from project.divers.base_diver import BaseDiver


class FreeDiver(BaseDiver):
    INITIAL_OXYGEN = 120

    def __init__(self, name: str):
        super().__init__(name, oxygen_level=self.INITIAL_OXYGEN)

    def miss(self, time_to_catch: int):
        oxygen_reduction = time_to_catch * 0.6
        difference = round(self.oxygen_level - oxygen_reduction)

        if difference < 0:
            self.oxygen_level = 0.0
        else:
            self.oxygen_level -= oxygen_reduction

    def renew_oxy(self):
        self.oxygen_level = self.INITIAL_OXYGEN
