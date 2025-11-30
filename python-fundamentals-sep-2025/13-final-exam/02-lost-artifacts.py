import re

artifact_regex = re.compile(
    r'(\*|\^)+(?P<artifact>[A-Za-z ]{6,})(\*|\^)+.*?'
    r'(\++)(?P<coordinates>(0|-?[0-9]\d*)(\.\d+),(0|-?[0-9]\d*)(\.\d+))\4'
)

text = input()
full_match = list(artifact_regex.finditer(text))

for match in full_match:
    if match.group('artifact') and match.group('coordinates'):
        print(f"Found {match.group('artifact')} at coordinates {match.group('coordinates')}.")

if not full_match:
    print("No valid artifacts found.")
