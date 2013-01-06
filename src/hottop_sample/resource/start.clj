(ns hottop-sample.resource.start
  (:require [hottop.resource :as res]
            [hottop-sample.view.html :as html]))

(def resource (res/create-readonly-html-resource html/start))
