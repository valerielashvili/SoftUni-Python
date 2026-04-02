from project.divers.base_diver import BaseDiver
from project.divers.free_diver import FreeDiver
from project.divers.scuba_diver import ScubaDiver
from project.fish.base_fish import BaseFish
from project.fish.deep_sea_fish import DeepSeaFish
from project.fish.predatory_fish import PredatoryFish


class NauticalCatchChallengeApp:
    VALID_DIVERS = {
        "FreeDiver": FreeDiver,
        "ScubaDiver": ScubaDiver
    }

    VALID_FISHES = {
        "DeepSeaFish": DeepSeaFish,
        "PredatoryFish": PredatoryFish
    }

    def __init__(self):
        self.divers: list = []
        self.fish_list: list = []

    def dive_into_competition(self, diver_type: str, diver_name: str):
        if diver_type not in self.VALID_DIVERS:
            return f"{diver_type} is not allowed in our competition."

        diver = self._get_diver(diver_name)
        if diver:
            return f"{diver_name} is already a participant."

        self.divers.append(self.VALID_DIVERS[diver_type](diver_name))
        return f"{diver_name} is successfully registered for the competition as a {diver_type}."

    def swim_into_competition(self, fish_type: str, fish_name: str, points: float):
        if fish_type not in self.VALID_FISHES:
            return f"{fish_type} is forbidden for chasing in our competition."

        fish = self._get_fish(fish_name)
        if fish:
            return f"{fish_name} is already permitted."

        self.fish_list.append(self.VALID_FISHES[fish_type](fish_name, points))
        return f"{fish_name} is allowed for chasing as a {fish_type}."

    def chase_fish(self, diver_name: str, fish_name: str, is_lucky: bool):
        diver: BaseDiver | None = self._get_diver(diver_name)
        if not diver:
            return f"{diver_name} is not registered for the competition."

        fish: BaseFish | None = self._get_fish(fish_name)
        if not fish:
            return f"The {fish_name} is not allowed to be caught in this competition."

        if diver.has_health_issue:
            return f"{diver_name} will not be allowed to dive, due to health issues."

        if diver.oxygen_level < fish.time_to_catch:
            return f"{diver_name} missed a good {fish_name}."
        elif diver.oxygen_level == fish.time_to_catch:

            if is_lucky:
                diver.hit(fish)
                self.__check_oxygen_level(diver)

                return f"{diver_name} hits a {fish.points}pt. {fish_name}."
            else:
                diver.miss(fish.time_to_catch)
                self.__check_oxygen_level(diver)

                return f"{diver_name} missed a good {fish_name}."

        elif diver.oxygen_level > fish.time_to_catch:
            diver.hit(fish)
            self.__check_oxygen_level(diver)

            return f"{diver_name} hits a {fish.points}pt. {fish_name}."

    #Implement health_recovery()

    def _get_diver(self, diver_name: str) -> BaseDiver | None:
        return next((d for d in self.divers if d.name == diver_name), None)

    def _get_fish(self, fish_name) -> BaseFish | None:
        return next((f for f in self.fish_list if f.name == fish_name), None)

    @staticmethod
    def __check_oxygen_level(diver: BaseDiver):
        if diver.oxygen_level == 0:
            diver.has_health_issue = True