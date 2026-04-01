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

    def register_climber(self, climber_type: str, climber_name: str):
        if climber_type not in self.VALID_CLIMBERS:
            return f"{climber_type} doesn't exist in our register."

        climber = self._find_climber(climber_name)

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
        climber = self._find_climber(climber_name)
        peak = self._find_peak(peak_name)

        recommended_gear = set(peak.get_recommended_gear())
        missing_gear = recommended_gear - set(gear)

        if missing_gear:
            climber.is_prepared = False
            return f"{climber_name} is not prepared to climb {peak_name}. Missing gear: {', '.join(sorted(missing_gear))}."
        else:
            return f"{climber_name} is prepared to climb {peak_name}."

    def perform_climbing(self, climber_name: str, peak_name: str):
        climber = self._find_climber(climber_name)
        peak = self._find_peak(peak_name)

        if not climber:
            return f"Climber {climber_name} is not registered yet."

        if not peak:
            return f"Peak {peak_name} is not part of the wish list."

        if climber.can_climb() and climber.is_prepared:
            climber.climb(peak)
            return f"{climber_name} conquered {peak_name} whose difficulty level is {peak.difficulty_level}."
        elif not climber.is_prepared:
            return f"{climber_name} will need to be better prepared next time."
        else:
            climber.rest()
            return f"{climber_name} needs more strength to climb {peak_name} and is therefore taking some rest."

    def get_statistics(self):
        selected_climbers = [c for c in self.climbers if c.conquered_peaks]
        climbers_sorted = sorted(selected_climbers, key=lambda c: (-len(c.conquered_peaks), c.name))

        stats = [
            f"Total climbed peaks: {len(self.peaks)}",
            "**Climber's statistics:**"
        ]

        climber_statistics = "\n".join(str(c) for c in climbers_sorted)
        stats.append(climber_statistics)

        return '\n'.join(stats)

    def _find_climber(self, climber_name) -> BaseClimber | None:
        return next((c for c in self.climbers if c.name == climber_name), None)

    def _find_peak(self, peak_name) -> BasePeak | None:
        return next((p for p in self.peaks if p.name == peak_name), None)
