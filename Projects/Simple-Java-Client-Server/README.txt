AUTHORS: Ikonija Bogojevic, Miguel Perez, Sandra Weber

DESCRIPTION

This is a simple client and server written in Java using the socket API. Both the client and server are multithreaded. The client can use multiple threads to simulate multiple simultanous connections to the server, which will create a new thread for every incoming connection.  



Client
--------

COMPILATION
$ javac Client.java

USAGE
$ java Client hostname

where hostname is the name of the machine the server is running on. If it is the same machine as the client, use localhost. 

The client program offers the user a choice of UNIX commands to run on the server. After the user chooses a command, the client creates a thread which connects to the server and sends it the user's choice. The client will print the answer that it receives from the server (unless the client is in benchmark mode).

The client program can also open multiple simultaneous connections to the server. To do this, choose option 7, Benchmark, from the main menu. It will then prompt for which command to benchmark and how many connections to open. It will calculate and display an average response time for all connections.



Server
--------

COMPILATION
$ javac Server.java

USAGE
$ java Server

This will make the server listen on port 15432 for incoming connections from client(s). The server listens for incoming connections in its main loop, and creates a new thread to handle every incoming connection. These threads run UNIX commands on the server machine and send their output to the client(s).
