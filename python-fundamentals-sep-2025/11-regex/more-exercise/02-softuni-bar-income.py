import re

pattern = re.compile(
    r'%(?P<customer>[A-Z][a-z]+)%.*?'
    r'<(?P<product>\w+)>.*?'
    r'\|(?P<count>0|[1-9]\d*)\|.*?'
    r'(?P<price>(0|[0-9]\d*)(\.\d+)?)\$'
)
total_income = 0.0

while (string := input()) != 'end of shift':
    m = pattern.search(string)
    if m:
        total_price = int(m.group('count')) * float(m.group('price'))
        total_income += total_price
        print(f"{m.group('customer')}: {m.group('product')} - {total_price:.2f}")

print(f"Total income: {total_income:.2f}")
