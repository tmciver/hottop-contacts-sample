(ns hottop-sample.resource.create-contact
  (:require [hottop.resource :as res]
            [hiccup.core :as hiccup]
            [hiccup.form :as form]))

(defn- html-template
  "HTML template to be used for all HTML pages."
  [subtitle body]
  (hiccup/html
   [:head
    [:title (str "Hottop Sample App - " subtitle)]]
   [:body
    body]))

(defn- get-create-contact
  [_]
  (html-template "Create Contact"
                 (hiccup/html [:h2 "Create a new contact"]
                              (form/form-to [:post "/contacts"]
                                            [:lable "First name: "]
                                            (form/text-field "fname")
                                            [:br]
                                            [:lable "Last name: "]
                                            (form/text-field "lname")
                                            [:br]
                                            [:lable "Phone number: "]
                                            (form/text-field "number")))))

(def resource (res/create-readonly-html-resource get-create-contact identity))
