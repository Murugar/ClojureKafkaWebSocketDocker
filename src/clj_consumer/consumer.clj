(ns clj-consumer.consumer
  (:require [clojure.core.async :refer [go]])
  (:import [org.apache.kafka.clients.consumer KafkaConsumer]
           [org.apache.kafka.common.serialization ByteArrayDeserializer])
  (:gen-class))

(def host (if-let [host (System/getenv "HOST")] host "192.168.99.100"))

(defn start-consumer
  [cb]
  (println "Kafka Consumer Started")
  (def c-cfg
    {"bootstrap.servers" (str host  ":9092")
     "group.id" "avg-rate-consumer"
     "auto.offset.reset" "earliest"
     "enable.auto.commit" "true"
     "key.deserializer" ByteArrayDeserializer
     "value.deserializer" ByteArrayDeserializer})

  (def consumer (doto (KafkaConsumer. c-cfg)
                  (.subscribe ["test"])))
  (while true
    (let [records (.poll consumer 100)]
      (doseq [record records]
        (cb (String. (.value record) "UTF-8"))))))

