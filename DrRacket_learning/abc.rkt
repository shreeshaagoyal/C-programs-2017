;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname abc) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))
; weight-rejection : number -> string
; given a weight in kilos, return a rejection string
(define(weight-rejection weight)
  (cond [(<= weight 52)  "Below average"]
        [(< weight 57)  "Above average"]
        [(>= weight 57)  "Illegal"]))

(check-expect (weight-rejection 50) "Below average")
(check-expect (weight-rejection 52) "Below average")
(check-expect (weight-rejection 56) "Above average")
(check-expect (weight-rejection 57) "Illegal")
(check-expect (weight-rejection 60) "Illegal")