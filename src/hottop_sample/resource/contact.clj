(ns hottop-sample.resource.contact
  (:require [hottop.resource :as res]
            [hottop-sample.view.html :as html]
            [hottop-sample.db :as db]
            [clojure.pprint :as pp])
  (:refer-clojure :exclude [get]))

(defn- get
  "Returns a map representing the contact with the ID given by the id param in
the request."
  [request]
  (let [{{id :id} :params} request
        id (Integer/parseInt id)]
    (if (> id 0)
      (do
        (println "contact ID:" id)
        (let [contact (db/get-contact id)]
          (println "Contact:" contact)
          contact))
      {:status 400 :body "Error: Invalid contact ID."})))

(def resource (-> (res/create-readonly-html-resource get html/contact)))
