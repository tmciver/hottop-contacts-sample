(defproject hottop-sample "0.0.1"
  :description "A sample app to demonstrate hottop."
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [hottop "0.1.1"]
                 [hiccup "1.0.0"]
                 [ring/ring-jetty-adapter "1.0.0-RC1"]]
  :main ^:skip-aot hottop-sample.core)