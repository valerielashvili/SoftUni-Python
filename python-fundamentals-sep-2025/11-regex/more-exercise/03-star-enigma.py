import re

key_pattern = re.compile(r'[star]', flags=re.IGNORECASE)
message_pattern = re.compile(
    r'@(?P<planet>[A-Z][a-z]+)[^@!:>-]*?'
    r':(?P<population>0|[1-9]\d*)[^@!:>-]*?'
    r'!(?P<attack_type>[AD])![^@!:>-]*?'
    r'->(?P<soldier_cnt>0|[1-9]\d*)'
)
attacked_planets = []
destroyed_planets = []

num = int(input())
for n in range(num):
    string = input()
    decrypt_key = 0
    decrypted = ''

    key_match = key_pattern.findall(string)
    if key_match:
        decrypt_key = len(key_match)

    for c in string:
        decrypted += chr(int(ord(c)) - decrypt_key)

    message_match = message_pattern.search(decrypted)
    if message_match:
        attack_type = message_match.group('attack_type')
        if attack_type == 'A':
            attacked_planets.append(message_match.group('planet'))
        elif attack_type == 'D':
            destroyed_planets.append(message_match.group('planet'))

print(f"Attacked planets: {len(attacked_planets)}")
for planet in sorted(attacked_planets):
    print(f"-> {planet}")

print(f"Destroyed planets: {len(destroyed_planets)}")
for planet in sorted(destroyed_planets):
    print(f"-> {planet}")
