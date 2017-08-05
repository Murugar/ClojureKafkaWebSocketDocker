(defproject clj-consumer "0.1.0-SNAPSHOT"
  :description "Kafka WebSockets Clojure"
  :url "http://example.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [org.clojure/core.async "0.3.443"]
                 [org.apache.kafka/kafka_2.11 "0.10.2.1"]
                 [org.apache.kafka/kafka-clients "0.10.2.1"]]
  :main ^:skip-aot clj-consumer.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
