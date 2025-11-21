import re
product_regex = re.compile(r'@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+')
num = int(input())

for n in range(num):
    product, product_group = input(), ''
    match = product_regex.match(product)

    if match:
        for digit in re.findall(r'\d', match.group()):
            product_group += digit
        if not product_group:
            product_group = '00'
        print(f"Product group: {product_group}")
    else:
        print("Invalid barcode")
