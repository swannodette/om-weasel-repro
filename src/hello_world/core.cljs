(ns hello-world.core
  (:require [om.core :as om]
            [om.dom :as dom]
            [weasel.repl :as repl]))

(enable-console-print!)

(when-not (repl/alive?)
  (repl/connect "ws://localhost:9001"))

(def app-state (atom {:text "Hello world!!!!"}))

(om/root
  (fn [app owner]
    (reify om/IRender
      (render [_]
        (dom/h1 nil (:text app)))))
  app-state
  {:target (. js/document (getElementById "app"))})
