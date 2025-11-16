import re

title_re = re.compile(r'<title>(?P<title>[^<>]*)</title>')
body_re = re.compile(r'<body>.*</body>')
content_re = re.compile(r'>(?P<content>[^><]*)<')

html = input()

title = title_re.search(html).group('title')
body = body_re.search(html).group()
content_iter = content_re.finditer(body)
content = ''

for text in content_iter:
    content += text.group('content').replace('\\n', '')

if title and content:
    print(f"Title: {title}\n"
          f"Content: {content}")
