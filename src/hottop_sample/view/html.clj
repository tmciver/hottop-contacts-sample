(ns hottop-sample.view.html
  (:require [hiccup.core :as hiccup]
            [hiccup.form :as form]
            [hiccup.element :as elem]))

(defn- html-template
  "HTML template to be used for all HTML pages."
  [subtitle body]
  (hiccup/html
   [:html
    [:head
     [:title (str "Hottop Sample App - " subtitle)]]
    [:body
     body]]))

(defn start
  [_]
  (html-template "Welcome!" (elem/link-to "/contacts" "See your contacts")))

(defn create-contact
  [_]
  (html-template "Create Contact"
                 (hiccup/html [:h2 "Create a new contact"]
                              (form/form-to [:post "/contact"]
                                            [:label "First name: "]
                                            (form/text-field "fname")
                                            [:br]
                                            [:label "Last name: "]
                                            (form/text-field "lname")
                                            [:br]
                                            [:label "Phone number: "]
                                            (form/text-field "number")
                                            [:br]
                                            (form/submit-button "Create")))))

(defn- contact-to-table-row
  "Formats the given contact as an HTML table row."
  [contact]
  (hiccup/html
   [:tr
    [:td (:lname contact)]
    [:td (:fname contact)]
    [:td (:phone contact)]
    [:td (:desc contact)]]))

(defn- contacts-to-table
  "Formats the given seq of contacts as an HTML table."
  [contacts]
  (hiccup/html
   [:table {:border "1"}
    [:tr
     [:th "Last Name"] [:th "First Name"] [:th "Phone Number"] [:th "Description"]]
    (map contact-to-table-row contacts)]))

(defn contacts
  "Formats the given seq of contacts as a page of HTML."
  [contacts]
  (html-template "Contacts" (contacts-to-table contacts)))
