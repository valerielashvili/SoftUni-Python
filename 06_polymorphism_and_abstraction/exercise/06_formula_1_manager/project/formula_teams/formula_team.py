from abc import ABC, abstractmethod


class FormulaTeam(ABC):
    MIN_BUDGET = 1_000_000

    def __init__(self, budget: int):
        self.budget = budget

    @property
    def budget(self) -> int:
        return self._budget

    @budget.setter
    def budget(self, value: int):
        if value < self.MIN_BUDGET:
            raise ValueError("F1 is an expensive sport, find more sponsors!")
        self._budget = value

    @staticmethod
    def sponsor_reward(position, tiers):
        eligible = [money for tier_pos, money in tiers.items() if position <= tier_pos]
        return max(eligible) if eligible else 0

    @abstractmethod
    def calculate_revenue_after_race(self, race_pos: int):
        pass
