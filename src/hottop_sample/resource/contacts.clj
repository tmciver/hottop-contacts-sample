(ns hottop-sample.resource.contacts
  (:require [hottop.resource :as res]
            [hottop-sample.view.html :as html])
  (:refer-clojure :exclude [get]))

(def ^:private db (ref {1 {:fname "Dorothy"
                           :lname "Gale"
                           :phone "867-5309"
                           :desc "She's not in Kansas anymore."}
                        2 {:fname "Scarecrow"
                           :lname ""
                           :phone "555-1234"
                           :desc "If he only had a brain."}
                        3 {:fname "Tinman"
                           :lname ""
                           :phone "555-5678"
                           :desc "If he only had a heart."}}))

(defn- get
  "Returns a seq of all the contacts in the database."
  [request]
  (vals @db))

(def resource (res/create-readonly-html-resource get html/contacts))
