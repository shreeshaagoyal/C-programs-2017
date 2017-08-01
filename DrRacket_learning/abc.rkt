;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname abc) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))
; a frog is (make-frog string number)
(define-struct frog (species mass))

(make-frog "tree" 39)
(make-frog "ground" 230)

; fits-in-display-case? : frog number -> boolean
; does the frog fit in the display case?
(define (fits-in-display-case? a-frog case-size)
  (<= (frog-mass a-frog) case-size))

(check-expect (fits-in-display-case? (make-frog "tree" 39)
                                     150)
              true)
(check-expect (fits-in-display-case? (make-frog "ground" 230)
                                     150)
              false)
(check-expect (fits-in-display-case? (make-frog "ground" 150)
                                     150)
              true)