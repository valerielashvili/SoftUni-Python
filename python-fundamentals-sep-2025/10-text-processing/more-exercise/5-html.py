title = input()
content = input()
title = f"<h1>\n    {title}\n</h1>\n"
content = f"<article>\n    {content}\n</article>\n"
comments = ''

while (comment := input()) != 'end of comments':
    comments += f"<div>\n    {comment}\n</div>\n"

print(f"{title}{content}{comments}")
