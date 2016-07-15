
(ns respo-inflow-pop.component.dialog
  (:require [respo.alias :refer [create-comp div]]
            [respo.component.text :refer [comp-text]]
            [respo-inflow-pop.style.layout :as layout]
            [respo-inflow-pop.style.widget :as widget]
            [respo-inflow-pop.style.decoration :as decoration]))

(defn on-focus [e dispatch!])

(defn render [on-close element-inside]
  (fn [state mutate!]
    (div
      {:style
       (merge
         layout/float-fullscreen
         decoration/dim
         layout/hold-center),
       :event {:click (fn [e dispatch!] (on-close))}}
      (div
        {:style widget/card, :event {:click on-focus}}
        element-inside))))

(def comp-dialog (create-comp :dialog render))
