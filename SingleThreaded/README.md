Single-Threaded Math Server & Client (Java)
Project Overview

A lightweight, single-threaded client-server application in Java.
The Math Server processes basic arithmetic commands (ADD, SUB, MUL, DIV) sent by the Client, then returns the result.
Communication uses Java's sockets and data streams for structured messaging.

Features

Math commands supported:

ADD a b → a + b

SUB a b → a – b

MUL a b → a × b

DIV a b → a ÷ b (with division-by-zero handling)

Graceful termination when client sends exit

Single-threaded: handles one client at a time

Uses DataInputStream & DataOutputStream for structured communication

Clean, minimal code with:

ServerSocket

Socket

Java I/O and networking APIs

Project Structure
.
├── MathServer.java
├── MathClient.java
└── README.md

How to Run
javac MathServer.java MathClient.java

Run Server
java MathServer

Run Client (in a different terminal)
java MathClient


Then, use commands like:

ADD 5 3
DIV 7 0
exit

Notes:
Socket Programming Insights

Socket programming enables communication between programs – whether on the same or different machines 

A socket is an endpoint for sending/receiving data. The java.net.Socket class is used by clients, while ServerSocket listens for incoming connections from clients 

Steps in Java (TCP):

Server creates a ServerSocket on a port.

Server calls accept() to await a client.

Client uses Socket(address, port) to connect.

Once connected, communication happens via I/O streams from the sockets 

After you're done, always close the socket; this automatically closes its input/output streams too 

Communication uses streams:

InputStream (client → server)

OutputStream (server → client)

These can be wrapped by higher-level readers or writers for easier text/binary handling

Classes used:
1. ServerSocket

Used in server

Listens on a port and waits for clients.

When a client connects, it gives a Socket.

2. Socket

Represents the actual link between client ↔ server.

3. DataInputStream

Reads data coming from the other side.

Example: reads commands like "ADD 5 3".

4. DataOutputStream

Sends data to the other side.

Example: sends results like "Result: 8".

5. System.in

Used in client

Standard input (keyboard).

6. BufferedReader

Used in client

Makes reading text from keyboard easier.

7. String methods

split() → breaks input into parts (ADD, 5, 3).

equalsIgnoreCase() → checks exit or EXIT.

parseInt() → converts "5" into number 5.

📌 Super-Simple Flow

Client: User types → read from keyboard → send to server.

Server: Receives command → does math → sends result.

Client: Receives result → shows on screen.