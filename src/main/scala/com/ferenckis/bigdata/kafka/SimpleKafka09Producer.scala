package com.ferenckis.bigdata.kafka

object SimpleKafka09Producer extends App {

  import java.util.Properties
  import java.net._

  import org.apache.kafka.clients.producer._

  val  props = new Properties()
  props.put("bootstrap.servers", "192.168.0.20:32773")

  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val TOPIC="topic"

  (1 to 10000000).foreach(i => producer.send(new ProducerRecord(TOPIC, "key", s"from ${InetAddress.getLocalHost} hello $i")))


  val record = new ProducerRecord(TOPIC, "key", "the end "+new java.util.Date)
  producer.send(record)

  producer.close()

}
