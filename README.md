# UserDemo
my springboot project 1
A RESTful API built with Java SpringBoot using maven
The application has only one dependency (other than the 2 default dependencies that comes with springboot) that i added which is the spring boot starter web
It creates 2 files (message and log) in .txt format
It has 1 post endpoint that is use to write to both files concurrently.
The application has 3 get endpoint whose responsibilities are as follows:
-1-/message - to read from the message file and return the content of it.
-2- /message-count - to count the number on times a message was posted into the message file and return the said number.
-3- /log-message - to read and return the default message passed into the log file which indicates a successful posting / writing operation has occured.
