(ns clj-repl.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn execute [string]
  (if (= string "exit")
    nil
    (do
      (eval (read-string string))
      true)))

(defn prompt-reader []
  (print "|")
  (flush)
  (read-line))

(defn prompt [reader-fn]
  (loop []
    (if (execute (reader-fn))
      (recur)
      nil)))
