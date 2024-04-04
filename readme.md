# Wikimedia Streaming


- Wikimedia stream api : `https://stream.wikimedia.org/v2`


##### Scenario :

- Subscribe to wikimedia streaming api
- Sending request to stream api
- Sending messages to kafka topic `wikimedia_stream_topic`
- Listening kafka topic and log


### Running application 

- Start docker-compose.yml file
```
docker-compose up -d
```

- Running java application
- Send GET request <br>
**Triggering api**
```
curl --location 'localhost:8080/api/v1/wikimedia'
```
- Check logs and kafka topic <br>
Example logs:
```
2024-04-04T16:20:26.974+03:00  INFO 3987 --- [wikimedia-event-stream] [ctor-http-nio-2] c.w.W.E.Stream.producer.KafkaProducer    : Sending message to topic : {"$schema":"/mediawiki/recentchange/1.0.0","meta":{"uri":"https://www.wikidata.org/wiki/Q124657276","request_id":"4bde5654-cd62-4a9e-9d45-2fd9f62eaa07","id":"69e29d65-8110-40b7-a82f-3c3010061a3b","dt":"2024-04-04T13:20:26Z","domain":"www.wikidata.org","stream":"mediawiki.recentchange","topic":"eqiad.mediawiki.recentchange","partition":0,"offset":4997690749},"id":2183136981,"type":"edit","namespace":0,"title":"Q124657276","title_url":"https://www.wikidata.org/wiki/Q124657276","comment":"/* wbsetlabel-add:1|ast */ Dominik Grafenthin","timestamp":1712236826,"user":"XabatuBot","bot":true,"notify_url":"https://www.wikidata.org/w/index.php?diff=2119249692&oldid=2087037347&rcid=2183136981","minor":false,"patrolled":true,"length":{"old":7153,"new":7232},"revision":{"old":2087037347,"new":2119249692},"server_url":"https://www.wikidata.org","server_name":"www.wikidata.org","server_script_path":"/w","wiki":"wikidatawiki","parsedcomment":"‎<span dir=\"auto\"><span class=\"autocomment\">Added [ast] label: </span></span> Dominik Grafenthin"}
2024-04-04T16:20:26.980+03:00  INFO 3987 --- [wikimedia-event-stream] [ntainer#0-0-C-1] c.w.W.E.Stream.service.StreamService     : Event : {"$schema":"/mediawiki/recentchange/1.0.0","meta":{"uri":"https://www.wikidata.org/wiki/Q124657276","request_id":"4bde5654-cd62-4a9e-9d45-2fd9f62eaa07","id":"69e29d65-8110-40b7-a82f-3c3010061a3b","dt":"2024-04-04T13:20:26Z","domain":"www.wikidata.org","stream":"mediawiki.recentchange","topic":"eqiad.mediawiki.recentchange","partition":0,"offset":4997690749},"id":2183136981,"type":"edit","namespace":0,"title":"Q124657276","title_url":"https://www.wikidata.org/wiki/Q124657276","comment":"/* wbsetlabel-add:1|ast */ Dominik Grafenthin","timestamp":1712236826,"user":"XabatuBot","bot":true,"notify_url":"https://www.wikidata.org/w/index.php?diff=2119249692&oldid=2087037347&rcid=2183136981","minor":false,"patrolled":true,"length":{"old":7153,"new":7232},"revision":{"old":2087037347,"new":2119249692},"server_url":"https://www.wikidata.org","server_name":"www.wikidata.org","server_script_path":"/w","wiki":"wikidatawiki","parsedcomment":"‎<span dir=\"auto\"><span class=\"autocomment\">Added [ast] label: </span></span> Dominik Grafenthin"}
```