from typing import List

from project.customer import Customer
from project.dvd import DVD


class MovieWorld:
    DVD_CAPACITY = 15
    CUSTOMER_CAPACITY = 10

    def __init__(self, name: str):
        self.name = name
        self.customers = []
        self.dvds = []

    @classmethod
    def dvd_capacity(cls):
        return cls.DVD_CAPACITY

    @classmethod
    def customer_capacity(cls):
        return cls.CUSTOMER_CAPACITY

    def add_customer(self, customer: Customer):
        if len(self.customers) < MovieWorld.CUSTOMER_CAPACITY:
            self.customers.append(customer)

    def add_dvd(self, dvd: DVD):
        if len(self.dvds) < MovieWorld.DVD_CAPACITY:
            self.dvds.append(dvd)

    @staticmethod
    def find_customer(customers: List[Customer], customer_id: int):
        return next((c for c in customers if c.id == customer_id), None)

    @staticmethod
    def find_customer_dvd(customer: Customer, dvd_id: int):
        return next((d for d in customer.rented_dvds if d.id == dvd_id), None)

    def rent_dvd(self, customer_id: int, dvd_id: int):
        customer = self.find_customer(self.customers, customer_id)
        dvd = self.find_customer_dvd(customer, dvd_id)

        if customer and dvd:
            return f"{customer.name} has already rented {dvd.name}"
        elif customer and not dvd:
            dvd = next(d for d in self.dvds if d.id == dvd_id)
            if dvd.is_rented:
                return "DVD is already rented"
            elif customer.age < dvd.age_restriction:
                return f"{customer.name} should be at least {dvd.age_restriction} to rent this movie"
            else:
                dvd.is_rented = True
                customer.rented_dvds.append(dvd)
                return f"{customer.name} has successfully rented {dvd.name}"

    def return_dvd(self, customer_id: int, dvd_id: int):
        customer = self.find_customer(self.customers, customer_id)
        dvd = self.find_customer_dvd(customer, dvd_id)

        if customer and dvd:
            customer.rented_dvds.remove(dvd)
            dvd.is_rented = False
            return f"{customer.name} has successfully returned {dvd.name}"
        return f"{customer.name} does not have that DVD"

    def __repr__(self):
        customers = '\n'.join(c.__repr__() for c in self.customers)
        dvds = '\n'.join(d.__repr__() for d in self.dvds)
        return customers + '\n' + dvds
