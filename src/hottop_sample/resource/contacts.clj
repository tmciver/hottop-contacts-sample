(ns hottop-sample.resource.contacts
  (:require [hottop.resource :as res]
            [hottop-sample.view.html :as html]
            [hottop-sample.db :as db])
  (:refer-clojure :exclude [get]))

(defn- get
  "Returns a collection of all the contacts in the database."
  [request]
  (db/get-contacts))

(defn- post
  "POSTs a contact into the data store."
  [request]
  (let [{:strs [fname lname phone]} (:form-params request)
        contact (hash-map :fname fname :lname lname :phone phone)
        id (db/add-contact contact)]
    id))

(def resource (-> (res/create-readonly-html-resource get html/contacts)
                  (assoc-in [:methods :post] post)
                  (assoc :redirect-after-html-post "/contacts")))
