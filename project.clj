(defproject find-duplicates "0.1.0-SNAPSHOT"
  :description "Finds duplicate files based on their MD5 checksum"
  :url "https://github.com/stefanhengl/find-duplicates.git"
  :scm {:name "git" :url "https://github.com/stefanhengl/find-duplicates.git" }
  :license {:name "MIT"
            :url  "https://opensource.org/licenses/MIT"}
  :dependencies [
                 [org.clojure/clojure "1.9.0"]
                 ]
  :main ^:skip-aot find-duplicates.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
