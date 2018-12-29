# Spring Boot Private Chat Project

1-1 instant messaging project designed to demonstrate WebSockets in a load-balanced environment. Users can register, login/logout, see a friendslist, private message, and send/receive notifications. WebSocket usages include user presence monitoring, notifications, and chat messages.

## Notable Technologies/Design Decisions
- Backend: Java 8 with Sprint Boot
- Frontend: Angular.js
- Message Broker: RabbitMQ (PubSub pattern for multi-server messaging)
- Database: MySQL
- ORM: Hibernate
- WebSocket messaging protocol: Stomp
- WebSocket handler: Sock.js (with cross-browser fallbacks)
- Session Management: Spring Session Redis (works cross-server)
- Security: Spring Security
- Spring Controllers couple REST as well as WebSocket traffic
- Fractal Design

## Setup
1. Install system dependencies: latest versions (at the time of this writing) of Java, MySQL, Redis, RabbitMQ, Node, NPM
2. Install RabbitMQ Stomp plugin: `$ sudo rabbitmq-plugins enable rabbitmq_stomp`
3. Update `src/main/resources/application.properties` with your MySQL credentials and port
4. Execute `src/main/java/org/privatechat/shared/database/createDatabase.sql` to create the database
5. Execute `src/main/java/org/privatechat/shared/database/seedDatabase.sql` to seed the database with some users (passwords are bcrypted, but they are all "testtest")
6. `cd` to `src/main/resources/` and run `$ sudo npm install && gulp` 
7. `cd` to root of the project and execute `$ mvn spring-boot:run` or  (`$ mvn spring-boot:run -Drun.jvmArguments='-Dserver.port={{your port here}}'` if you wish to run a few servers)
8. Visit [http://localhost:8080/](http://localhost:8080) 

## Notes
- Chat messages are persisted to the database, notifications are not. Will add that functionality later.
- Uncomment `devtools` dependency in `pom.xml` for live reloading in development
- Notifications must be subscribed to in unique per-user channels. Despite enabling the `/user` message broker prefix, Spring's `convertAndSendToUser(...)` failed to update all nodes of a notification message transmission. Going to post a SO question soon!
- Friendlist feature is just every user in the database other than the current user (simple feature for demo, not meant to be realistic)
- Chat messages are `LIMIT`ed by 100
 
## Todos
- Separate out `index.js` file into smaller services/configs
- Persist notifications
- Figure out how to have Spring Security return a custom UserDTO on `/login`. Currently, after login, a call to `/api/user/requesting/info` is made and the `Principal` context drives the rest. Not elegant.
- Refactor `user` table `isPresent` (boolean) to be `numberOfConnections` (int).
- Implement notification emailer when recieving user is offline (batch up notifications in a time window)
- Implement auto-logout timer on frontend
- Implement smart pagination of messages on the frontend
- Implement a UUID for notifications topics subscription (currently using user id, which is unsecure)
- Wire up CSRF tokens with Spring Security
- ChatService.getExistingChatMessages(...) currently reverses the `List<ChatMessageDTO` collection because the query needs some attention.
- Handle frontend exception when requested chat user doesn't exist on the frontend
- Clean up hacky notifications SCSS
- Improve the way global error handler intercepts HTTPs responses
- Switch all e.printStackTrace to use the logger

## License
MIT
