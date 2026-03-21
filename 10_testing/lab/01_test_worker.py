class Worker:
    def __init__(self, name: str, salary: int, energy: int):
        self.name = name
        self.salary = salary
        self.energy = energy
        self.money = 0

    def work(self):
        if self.energy <= 0:
            raise Exception('Not enough energy.')

        self.money += self.salary
        self.energy -= 1

    def rest(self):
        self.energy += 1

    def get_info(self):
        return f'{self.name} has saved {self.money} money.'


from unittest import TestCase, main


class WorkerTests(TestCase):
    def test_worker_initialized(self):
        worker = Worker(name='Brainer', salary=100, energy=500)
        self.assertEqual(worker.name, 'Brainer')
        self.assertEqual(worker.salary, 100)
        self.assertEqual(worker.energy, 500)
        self.assertEqual(worker.money, 0)

    def test_energy_increment_after_rest(self):
        # Arrange
        worker = Worker(name='Brainer', salary=100, energy=500)
        self.assertEqual(worker.energy, 500)

        # Act
        worker.rest()

        # Assert
        self.assertEqual(worker.energy, 501)

    def test_work_with_no_energy(self):
        worker = Worker(name='Brainer', salary=100, energy=-1)
        with self.assertRaises(Exception) as e:
            worker.work()
        self.assertEqual('Not enough energy.', str(e.exception))

    def test_money_increased_after_work(self):
        worker = Worker(name='Brainer', salary=100, energy=500)
        self.assertEqual(worker.money, 0)
        worker.work()
        self.assertEqual(worker.money, 100)

    def test_energy_decreased_after_work(self):
        worker = Worker(name='Brainer', salary=100, energy=500)
        self.assertEqual(worker.energy, 500)
        worker.work()
        self.assertEqual(worker.energy, 499)

    def test_get_info(self):
        worker = Worker(name='Brainer', salary=100, energy=500)
        self.assertEqual(worker.get_info(), 'Brainer has saved 0 money.')


if __name__ == '__main__':
    main()
