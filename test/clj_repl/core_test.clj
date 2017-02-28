(ns clj-repl.core-test
  (:require [clojure.test :refer :all]
            [clj-repl.core :refer :all]))

(defn fake-prompt-reader [commands]
  (let [list (atom commands)]
    (fn []
      (let [return-value (first @list)
            rest-commands (rest @list)]
          (reset! list rest-commands)
          return-value))))

(def pr1 (fake-prompt-reader ["(println 1)"
                              "exit"]))

(deftest prompt-test
  (testing "it runs commands"
    (let [reader (fake-prompt-reader ["(println 1)" "exit"])]
      (is (= "" (prompt reader)))))
  (testing "it exits the prompt"))
    ; (is )))
