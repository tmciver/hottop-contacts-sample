(ns hottop-sample.resource.start
  (:require [hottop.resource :as res]
            [hiccup.core :as hiccup]
            [hiccup.element :as elem])
  (:refer-clojure :exclude [get]))

(defn- html-template
  "HTML template to be used for all HTML pages."
  [subtitle body]
  (hiccup/html
   [:head
    [:title (str "Hottop Sample App - " subtitle)]]
   [:body
    body]))

(defn- get
  [req]
  (html-template "Start" (elem/link-to "/contacts" "See your contacts")))

(def resource (res/create-readonly-html-resource get identity))
