from project.formula_teams.formula_team import FormulaTeam


class MercedesTeam(FormulaTeam):
    PETRONAS_TIERS = {
        1: 1_000_000,
        3: 500_000
    }
    TEAMVIEWER_TIERS = {
        5: 100_000,
        7: 50_000
    }
    RACE_EXPENSES = 200_000

    def __init__(self, budget: int):
        super().__init__(budget)

    def calculate_revenue_after_race(self, race_pos: int):
        revenue = (self.sponsor_reward(race_pos, self.PETRONAS_TIERS) +
                   self.sponsor_reward(race_pos, self.TEAMVIEWER_TIERS)) - self.RACE_EXPENSES
        self.budget += revenue
        return f"The revenue after the race is {revenue}$. Current budget {self.budget}$"
