class MoneyNotEnoughError(Exception):
    """Raised when money is not enough."""
    pass


class PINCodeError(Exception):
    """Raised when PIN code is not valid."""
    pass


class UnderageTransactionError(Exception):
    """Raised when underage transaction is not valid."""
    pass


class MoneyIsNegativeError(Exception):
    """Raised when money is negative."""
    pass


pin, balance, age = input().split(', ')
balance, age = map(int, (balance, age))

while (line := input()) != 'End':
    cmd, amount, entered_pin = (line.split('#') + [None])[:3]
    amount = int(amount)

    if cmd == 'Send Money':
        if balance < amount:
            raise MoneyNotEnoughError('Insufficient funds for the requested transaction')
        elif entered_pin != pin:
            raise PINCodeError('Invalid PIN code')
        elif age < 18:
            raise UnderageTransactionError('You must be 18 years or older to perform online transactions')

        balance -= amount
        print(f'Successfully sent {amount:.2f} money to a friend\n'
              f'There is {amount:.2f} money left in the bank account')

    elif cmd == 'Receive Money':
        savings = amount / 2
        if savings < 0:
            raise MoneyIsNegativeError('The amount of money cannot be a negative number')

        balance += savings
        print(f'{savings:.2f} money went straight into the bank account')
