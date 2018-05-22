(ns find-duplicates.core
  (:gen-class))


(require 'clojure.set)


(import 'java.security.MessageDigest
        'java.math.BigInteger)


(defn get-all-files [path]
  (filter #(.isFile %) (file-seq (clojure.java.io/file path)))
  )


(defn md5 [^String s]
  "Calculates md5 checksum of string"
  (let [algorithm (MessageDigest/getInstance "MD5")
        raw (.digest algorithm (.getBytes s))]
    (format "%032x" (BigInteger. 1 raw))))


(defn find-duplicates [path]
  "Finds duplicate files based on their md5 checksum"
  (def files (into #{} (get-all-files path)))
  (def unique-files (into #{} (vals (zipmap (map #(md5 (slurp %)) files) files))))
  (clojure.set/difference files unique-files)
  )


(defn -main [& args]
  (def duplicates (map #(clojure.string/replace (.getCanonicalPath %) #" " "\\\\ ") (find-duplicates (first args))))
  (doseq [item duplicates] (println item))
  )

