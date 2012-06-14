(ns hottop-sample.core
  (:require [hottop.core :as core]
            [hottop.resource :as resource]
            [ring.adapter.jetty :as ring-jetty]
            [ring.middleware.reload :as ring-reload]
            [clojure.pprint :as pp]))

(def hello-resource (resource/create-readonly-html-resource "/hello" (constantly "<a href=\"goodbye\">Hello!</a>")))
(def goodbye-resource (resource/create-readonly-html-resource "/goodbye" (constantly "<a href=\"hello\">Good Bye!</a>")))
(def my-app (core/app ["hello"] hello-resource))

(defn -main
  [port]
;  (pp/pprint hello-resource)
  (ring-jetty/run-jetty my-app {:port (Integer/parseInt port)}))
