; Martin Halvorson

; Takes in partial ordering as a hash-map and creates a partial ordering as a list

(def partial-ordering
  (hash-map
    'A #{'C}
    'B #{'H}
    'C #{'G}
    'G #{'D 'E}
    'D #{'F}
    'E #{'H}
    'H #{'F}
    'I #{'B 'E})) 

(def satisfy 
  (fn [precedes? objects]
    (reverse (unpreceded nil precedes? objects))))
    
(def unpreceded
  (fn [etc precedes? objects]
    (if (= objects '())
      objects
      (if (unpreceded? precedes? (first objects) (rest objects))
        (cons (first objects) (unpreceded nil precedes? (rest objects)))
        (unpreceded nil precedes? (concat (rest objects) (list (first objects))))))))
    
(def unpreceded?
  (fn [precedes? object other-objects]
    (= (filter (partial precedes? object) other-objects) '())))

(defn precedes?
    ([left right]
      (precedes? left right partial-ordering))
    ([left right partial-ordering]
      (contains? (get partial-ordering left) right)))
    
(def delete
  (fn [objects object]
    (remove (partial = object) objects)))


