
(ns inflow-popup.updater (:require [respo.cursor :refer [mutate]]))

(defn updater [store op op-data op-id op-time]
  (case op :states (update store :states (mutate op-data)) store))
