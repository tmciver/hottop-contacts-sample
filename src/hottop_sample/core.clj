(ns hottop-sample.core
  (:require [hottop-sample.resource.contacts :as contacts]
            [hottop-sample.resource.contact :as contact]
            [hottop-sample.resource.start :as start]
            [hottop-sample.resource.create-contact :as create]
            [hottop.core :as core]
            [hottop.resource :as resource]
            [ring.adapter.jetty :as ring-jetty]
            [ring.middleware.params :as rmp]))

(def my-app (-> (core/routes ["/"] start/resource
                             ["/contacts"] contacts/resource
                             ["/contact/:id"] contact/resource
                             ["/create-contact"] create/resource)
                rmp/wrap-params))

(defn -main
  [port]
  (ring-jetty/run-jetty my-app {:port (Integer/parseInt port)}))
