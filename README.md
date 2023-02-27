# SMTP
A simple mail server written in Java

# Faculty Of Computer And Artificial Intelligence Cairo University `FCAI-CU`

## 	Computer Networks Technology Assignment


## Example Simulation of an SMTP Protocol interaction between a Client and a Server

//  Client sends a HELO command to the server
- C: HELO example.com
- S: 250 Hello example.com, pleased to meet you.

//  Client sends a MAIL FROM command to the server
- C: MAIL FROM:<sender@fci-cu.edu.eg.com>
- S: 250 Ok

//  Client sends a RCPT TO command to the server
- C: RCPT TO:<recipient@fci-cu.edu.eg.com>
- S: 250 Ok

//  Client sends a DATA command to the server
- C: DATA
- S: 354 Enter message, ending with "end of email" on a line by itself

//  Client sends the email message to the server
- C: Subject: This is the subject of the email
- C:
- C: This is the body of the email
- C: end of email
- S: 250 Ok: queued as 12345

//  Client sends a QUIT command to the server
- C: QUIT
- S: 221 Bye



-- In the above simulation, the client initiates the interaction by sending a 'HELO' command to the server to introduce itself. The server responds with a greeting and a message indicating that it's pleased to meet the client.

-- Next, the client sends a 'MAIL FROM' command to identify the sender of the email message. The server responds with an acknowledgement that the sender has been identified.

-- The client then sends a 'RCPT TO' command to identify the recipient of the email message. The server again responds with an acknowledgement that the recipient has been identified.

-- The client then sends a 'DATA' command to indicate that it will be sending the actual email message to the server. The server responds with a message indicating that it's ready to receive the email message.

-- The client then sends the email message to the server, including the subject and body of the message. After the client is finished sending the message, it sends a period (".") on a line by itself to indicate the end of the message. The server responds with an acknowledgement that the message has been queued for delivery.

-- Finally, the client sends a 'QUIT' command to indicate that it's finished with the SMTP session. The server responds with a goodbye message and closes the connection.


![SMTP](https://img.shields.io/badge/SMTP-supported-brightgreen.svg)
