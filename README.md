# SpringBootKafka

######################## KAFKA SET UP ################################

sources: https://www.youtube.com/watch?v=EUzH9khPYgs, https://www.youtube.com/watch?v=NjHYWEV_E_o

Place the kafka folder in C drive

## Command to start zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

## Command to start the server
.\bin\windows\kafka-server-start.bat .\config\server.properties

## command to create a topic
.\bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092

## command to start the producer
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic quickstart-events

## command to start the consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic quickstart-events --from-beginning
