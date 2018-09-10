
(ns inflow-popup.comp.dialog
  (:require [respo.macros :refer [defcomp cursor-> list-> <> div span]]
            [inflow-popup.style.layout :as layout]
            [inflow-popup.style.widget :as widget]
            [inflow-popup.style.decoration :as decoration]
            [hsl.core :refer [hsl]]))

(defn on-focus [e dispatch! mutate!] )

(defcomp
 comp-dialog
 (on-close! element-inside)
 (div
  {:style (merge layout/float-fullscreen decoration/dim layout/hold-center {:z-index 100}),
   :on-click (fn [e d! m!] (on-close! m!))}
  (div {:on-click on-focus, :style widget/card} element-inside)))

(defcomp
 comp-menu-dialog
 (on-choose! on-close! candidates)
 (assert (fn? on-choose!) "on-choose! should be a function!")
 (assert (fn? on-close!) "on-close! should be a function!")
 (assert (map? candidates) "candidates was supposed to be a map!")
 (div
  {:style (merge layout/float-fullscreen decoration/dim layout/hold-center {:z-index 100}),
   :on-click (fn [e d! m!] (on-close! m!))}
  (list->
   {:on-click on-focus,
    :style {:background-color (hsl 0 0 100),
            :padding "16px 0",
            :max-height 600,
            :overflow :auto}}
   (->> candidates
        (map-indexed
         (fn [idx [k v]]
           [idx
            (div
             {:on-click (fn [e d! m!] (on-choose! k d! m!) (on-close! m!)),
              :style {:border-bottom (str "1px solid " (hsl 0 0 90)),
                      :padding "0 16px",
                      :line-height "32px",
                      :min-width 200,
                      :max-width 400,
                      :cursor :pointer,
                      :white-space :nowrap}}
             (<> v))]))))))
