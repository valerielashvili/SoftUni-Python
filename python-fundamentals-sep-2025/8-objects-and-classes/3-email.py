class Email:
    def __init__(self, sender, receiver, content):
        self.sender = sender
        self.receiver = receiver
        self.content = content
        self.is_sent = False

    def send(self):
        self.is_sent = True
    
    def get_info(self):
        return f"{self.sender} says to {self.receiver}: {self.content}. Sent: {self.is_sent}"

emails = []

tokens = input().split()
while tokens[0] != 'Stop':
    sender_name = tokens[0]
    receiver_name = tokens[1]
    message = tokens[2]

    email = Email(sender_name, receiver_name, message)
    emails.append(email)

    tokens = input().split()

emails_to_send = list(map(lambda x: int(x), input().split(', ')))

for e in emails_to_send:
    emails[e].send()

for email in emails:
    print(email.get_info())
