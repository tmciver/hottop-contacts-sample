(ns hottop-sample.core
  (:require [hottop-sample.resource.contacts :as contacts]
            [hottop-sample.resource.start :as start]
            [hottop-sample.resource.create-contact :as create]
            [hottop.core :as core]
            [hottop.resource :as resource]
            [ring.adapter.jetty :as ring-jetty]))

(def my-app (core/app ["/"] start/resource
                      ["/contacts"] contacts/resource
                      ["/create-contact"] create/resource))

(defn -main
  [port]
  (ring-jetty/run-jetty my-app {:port (Integer/parseInt port)}))
