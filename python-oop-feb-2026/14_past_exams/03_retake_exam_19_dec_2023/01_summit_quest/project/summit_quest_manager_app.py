from typing import List

from project.climbers.base_climber import BaseClimber
from project.climbers.arctic_climber import ArcticClimber
from project.climbers.summit_climber import SummitClimber
from project.peaks.base_peak import BasePeak
from project.peaks.arctic_peak import ArcticPeak
from project.peaks.summit_peak import SummitPeak


class SummitQuestManagerApp:
    VALID_CLIMBERS = {
        "ArcticClimber": ArcticClimber,
        "SummitClimber": SummitClimber
    }

    VALID_PEAKS = {
        "ArcticPeak": ArcticPeak,
        "SummitPeak": SummitPeak
    }

    def __init__(self):
        self.climbers: list = []
        self.peaks: list = []

    def find_climber(self, climber_name):
        return next((c for c in self.climbers if c.name == climber_name), None)

    def register_climber(self, climber_type: str, climber_name: str):
        if climber_type not in self.VALID_CLIMBERS:
            return f"{climber_type} doesn't exist in our register."

        climber = self.find_climber(climber_name)

        if climber:
            return f"{climber_name} has been already registered."

        climber = self.VALID_CLIMBERS[climber_type](climber_name)
        self.climbers.append(climber)

        return f"{climber_name} is successfully registered as a {climber_type}."

    def peak_wish_list(self, peak_type: str, peak_name: str, peak_elevation: int):
        if peak_type not in self.VALID_PEAKS:
            return f"{peak_type} is an unknown type of peak."

        peak = self.VALID_PEAKS[peak_type](peak_name, peak_elevation)
        self.peaks.append(peak)

        return f"{peak_name} is successfully added to the wish list as a {peak_type}."

    def check_gear(self, climber_name: str, peak_name: str, gear: List[str]):
        peak: BasePeak = next((p for p in self.peaks if p.name == peak_name), None)
        climber: BaseClimber = self.find_climber(climber_name)
        recommended_gear: list = peak.get_recommended_gear()

        if all(gear) in recommended_gear:
            return f"{climber_name} is prepared to climb {peak_name}."

        climber.is_prepared = False
        missing_gear = sorted([g for g in recommended_gear if g not in gear], key=lambda g: g)

        return f"{climber_name} is not prepared to climb {peak_name}. Missing gear: {', '.join(missing_gear)}."
