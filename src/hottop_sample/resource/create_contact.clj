(ns hottop-sample.resource.create-contact
  (:require [hottop.resource :as res]
            [hottop-sample.view.html :as html]))

(def resource (res/create-readonly-html-resource (constantly nil) html/create-contact))
