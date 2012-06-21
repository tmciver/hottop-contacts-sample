(ns hottop-sample.core
  (:require [hottop.core :as core]
            [hottop.resource :as resource]
            [ring.adapter.jetty :as ring-jetty]
            [ring.middleware.reload :as ring-reload]
            [clojure.pprint :as pp]))

(def page1 (resource/create-readonly-html-resource "/page1" (constantly "<a href=\"page2\">Page 2</a>")))
(def page2 (resource/create-readonly-html-resource "/page2" (constantly "<a href=\"page3\">Page 3</a>")))
(def page3 (resource/create-readonly-html-resource "/page3" (constantly "<a href=\"page1\">Page 1</a>")))
(def my-app (core/app ["page1"] page1
                      ["page2"] page2
                      ["page3"] page3))

(defn -main
  [port]
  (ring-jetty/run-jetty my-app {:port (Integer/parseInt port)}))
