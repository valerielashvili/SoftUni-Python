from project.formula_teams.formula_team import FormulaTeam


class RedBullTeam(FormulaTeam):
    ORACLE_TIERS = {
        1: 1_500_000,
        2: 800_000
    }
    HONDA_TIERS = {
        8: 20_000,
        10: 10_000
    }
    RACE_EXPENSES = 250_000

    def __init__(self, budget: int):
        super().__init__(budget)

    def calculate_revenue_after_race(self, race_pos: int):
        revenue = (self.sponsor_reward(race_pos, self.ORACLE_TIERS) +
                   self.sponsor_reward(race_pos, self.HONDA_TIERS)) - self.RACE_EXPENSES
        self.budget += revenue
        return f"The revenue after the race is {revenue}$. Current budget {self.budget}$"
