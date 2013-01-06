(ns hottop-sample.db)

(def contacts (ref {1 {:fname "Dorothy"
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

(defn get-contacts
  "Returns a collection of maps, each map representing a contact. Currently, the
maps contain the following keys:
  :id - an integer ID
  :fname - first name
  :lname - last name
  :phone - phone number (as string)
  :desc - description"
  []
  (map (fn [[id contact]]
         (assoc contact :id id))
       @contacts))

(defn get-contact
  "Return a map representing the contact with the given id. The id is assoc'd
into the map."
  [id]
  (when-let [contact (@contacts id)]
    (assoc contact :id id)))

(defn add-contact
  "Add the given contact to the database. The integer ID of the new contact is
returned."
  [contact]
  (let [id (inc (apply max (keys @contacts)))]
    (alter contacts conj [id contact])
    id))
