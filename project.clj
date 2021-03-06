(defproject reagent-app-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.520"]
                 [org.clojure/test.check "0.9.0" :scope "test"]
                 [reagent "0.8.1" :exclusions [cljsjs/react
                                               cljsjs/react-dom
                                               cljsjs/react-dom-server
                                               cljsjs/create-react-class]]
                 [re-frame "0.10.8"]
                 [orchestra "2018.12.06-2"]]
  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.19"]]
  :clean-targets ["target/" "main.js"]
  :aliases {"figwheel" ["run" "-m" "user" "--figwheel"]}
  :profiles {:dev {:dependencies   [[figwheel-sidecar "0.5.18"]
                                    [cider/piggieback "0.4.1"]
                                    [com.bhauman/figwheel-main "0.1.9"]
                                    [com.bhauman/rebel-readline-cljs "0.1.4"]]
                   :source-paths   ["src" "env/dev"]
                   :resource-paths ["target"]
                   :cljsbuild      {:builds [{:id           "main"
                                              :source-paths ["src" "env/dev"]
                                              :figwheel     true
                                              :compiler     {:output-to     "target/expo/index.js"
                                                             :main          "env.expo.main"
                                                             :output-dir    "target/expo"
                                                             :optimizations :none
                                                             :target        :nodejs}}]}
                   :repl-options   {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}})
