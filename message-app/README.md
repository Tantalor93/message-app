## Message app
this application periodically sends unstructured 
text message to topic `test` with
key `message-app-{current millis}`, also endpoint `/ping` is exposed which sends a new
message with same key to same topic.

This application is configured to bootstrap kafka connection to broker to kafka broker `benky-kafka:9092`