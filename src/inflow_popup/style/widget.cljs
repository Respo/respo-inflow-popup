
(ns inflow-popup.style.widget (:require [hsl.core :refer [hsl]]))

(def button
  {:display "inline-block",
   :padding "0 8px",
   :line-height 2,
   :font-size "14px",
   :background-color (hsl 200 80 60),
   :color (hsl 0 0 100),
   :cursor "pointer"})

(def card {:background-color (hsl 0 0 100), :padding 16})
