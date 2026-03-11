from project.customer import Customer
from project.trainer import Trainer
from project.equipment import Equipment
from project.exercise_plan import ExercisePlan
from project.subscription import Subscription


class Gym:
    def __init__(self):
        self.customers = []
        self.trainers = []
        self.equipment = []
        self.plans = []
        self.subscriptions = []

    def add_customer(self, customer: Customer):
        if customer not in self.customers:
            self.customers.append(customer)

    def add_trainer(self, trainer: Trainer):
        if trainer not in self.trainers:
            self.trainers.append(trainer)

    def add_equipment(self, equipment: Equipment):
        if equipment not in self.equipment:
            self.equipment.append(equipment)

    def add_plan(self, plan: ExercisePlan):
        if plan not in self.plans:
            self.plans.append(plan)

    def add_subscription(self, subscription: Subscription):
        if subscription not in self.subscriptions:
            self.subscriptions.append(subscription)

    def subscription_info(self, subscription_id: int):
        subscription = self.find_object(subscription_id, self.subscriptions)
        customer = self.find_object(subscription.customer_id, self.customers)
        trainer = self.find_object(subscription.trainer_id, self.trainers)
        exercise_plan = self.find_object(subscription.exercise_id, self.plans)
        equipment = self.find_object(exercise_plan.equipment_id, self.equipment)
        return '\n'.join((
                repr(subscription),
                repr(customer),
                repr(trainer),
                repr(equipment),
                repr(exercise_plan))
            )

    @staticmethod
    def find_object(obj_id: int, obj_list: list) -> Subscription | Customer | Trainer | Equipment | ExercisePlan:
        return next((o for o in obj_list if o.id == obj_id), None)