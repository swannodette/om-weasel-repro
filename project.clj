(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2850"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.omcljs/om "0.8.8"]
                 [weasel/weasel "0.6.0-SNAPSHOT"]
                 [com.cemerick/piggieback "0.1.5"]]

  :plugins [[lein-cljsbuild "1.0.4"]]

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                 :init (do
                         (require 'weasel.repl.websocket)
                         (defn start-weasel
                           [& opts] (cemerick.piggieback/cljs-repl
                                      :repl-env (apply weasel.repl.websocket/repl-env opts))))}

  :source-paths ["src"]

  :clean-targets ["out/hello_world" "out/hello_world.js"]

  :cljsbuild {
    :builds [{:id "hello-world"
              :source-paths ["src"]
              :compiler {
                :output-to "out/hello_world.js"
                :output-dir "out"
                :optimizations :none
                :cache-analysis true
                :source-map true}}]})
