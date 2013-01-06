(ns hottop-sample.resource.contacts
  (:require [hottop.resource :as res]
            [hottop-sample.view.html :as html]
            [hottop-sample.db :as db])
  (:refer-clojure :exclude [get]))

(defn- get
  "Returns a collection of all the contacts in the database."
  [request]
  (db/get-contacts))

(def resource (res/create-readonly-html-resource get html/contacts))
