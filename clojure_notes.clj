; Stuff to look at
;; Types in OCaml

;~~~~~~~~~ More Examples ~~~~~~~~~~~

; Filtering with a map
(filter (fn [[k v]] (even? k)) {1 "a", 2 "b", 3 "c", 4 "d"})
;>> ([2 "b"] [4 "d"])

; How map would be written
(def map1
  (fn [func arg2]
    (if (empty? arg2)
      '()
      (cons 
        (func (first arg2)) 
        (map1 func (rest arg2))))))
        
(apply distinct? '(1 2 3 3))
;>> false

;~~~~~~~~~~ Atoms ~~~~~~~~~~~~

(def a (atom 1))
(deref a)
;>> 1

(reset! a 3)
(deref a)
;>> 3

;~~~~~~~~~~~~ Futures ~~~~~~~~~~~~



; ~~~~~~~~~~~ Maps ~~~~~~~~~~~~~~~

(def m (assoc (hash-map) 'a 1 'b 2 'c 3))
;>> {a 1, b 2, c 3}

(contains? m 'a)
;>> true

(merge (assoc (hash-map) 'd 4) m)
;>> {d 4, a 1, b 2, c 3}

;~~~~ Function Definitions ~~~~~~~

(apply max '(1 2 3))
;>> 3 ~~~ equivalent to (max 1 2 3)

(concat '(1 2) '(3 4))
;>> (1 2 3 4)

(cons 1 '(2 3))
;>> (1 2 3)

(count '(1 2 3 4))
;>> 4 ~~~ length

(distinct? 1 2 3 3)
;>> false

(filter even? '(1 2 3 4))
;>> (2 4) ~~~ opposite of remove

; Different than a hash-map
(map inc '(1 2 3))
;>> (2 3 4)

((partial + 2) 5)
;>> 7 ~~~ (partial + 2) makes new function that adds 2 to input

(rand-nth '(1 2 3))
;>> <random value from list>

(range 4)
;>> (0 1 2 3)

(reduce + '(1 2 3))
;>> 6

(range)
;>> <infinite lazy seq>

(remove even? '(1 2 3 4))
;>> (1 3) ~~~ opposite of filter

(reverse '(1 2 3))
;>> (3 2 1)

(sort '(3 2 5 1 4))
;>> (1 2 3 4 5)

(take 2 '(1 2 3 4))
;>> (1 2)

;~~~~~~~ Syntax Notes/Examples ~~~~~~~~

; Functions evaluate arguments, then expression
(def add
  (fn [arg1 arg2]
    (+ arg1 arg2)))

; Multi-arity function
(defn add2
  ([]
    0)
  ([& args]
    (apply + args)))
    
; Macros evaluate expression, then arguments
(defmacro addSecond
  [arg1 arg2]
    (+ (second arg1) (second arg2)))

(addSecond (1 2) (3 4))
;>> 6 ~~~ adds second elements of each list

(def fac
  (fn [n]
    (loop [n n result 1]
      (if (= n 1)
        result
        (recur (- n 1) (* result n))))))
        
(def cats
  (fn [n]
    (let [numCats n]
      (println "I have" numCats "cats!"))))
        
; Collections
; * () Lists
; * [] Vectors
; * #{} Sets
; * {} Maps

;~~~~~~~~ Basic Stuff ~~~~~~~~~~~

(first '(1 2 3))
;>> 1

(second '(1 2 3))
;>> 2

(rest '(1 2 3))
;>> (2 3)

(last '(1 2 3))
;>> 3

(butlast '(1 2 3))
;>> (1 2)

(nth '(0 1 2) 1)
;>> 1

(list 1 2 3)
;>> (1 2 3)

(vector 1 2 3)
;>> [1 2 3]

(max 1 2 3)
;>> 3

(min 1 2 3)
;>> 1

(even? 2)
;>> true

(odd? 2)
;>> false

;~~~~~~~~~~~ System Stuff ~~~~~~~~~~~

(type :a)
;>> clojure.lang.Keyword

+
;>> #object[clojure.core#_PLUS_0x64a84641 "clojure.core#_PLUS_#64a84641"]

nil

