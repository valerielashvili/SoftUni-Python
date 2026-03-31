from project.climbers.base_climber import BaseClimber
from project.peaks.base_peak import BasePeak


class SummitClimber(BaseClimber):
    MINIMUM_STRENGTH = 75

    def __init__(self, name: str):
        super().__init__(name, 150)

    def can_climb(self):
        if self.strength >= self.MINIMUM_STRENGTH:
            return True
        else:
            return False

    def climb(self, peak: BasePeak):
        if peak.difficulty_level == "Extreme":
            self.strength -= 30 * 2.5
        elif peak.difficulty_level == "Advanced":
            self.strength -= 30 * 1.3

        self.conquered_peaks.append(peak.name)
