
.text
.global main
@ Function that `main` should call
fib:
    
    
    @ Initialize the first two numbers in the sequence
    MOV r1, #0  @ current
    MOV r2, #1  @ previous
    @ Fill in the Fibonacci algorithm here
loop:
    sub r0, #1
    cmp r0, #0
    ble stopp
    add r3, r1, r2
    MOV r1, r2 
    MOV r2, r3
    
    
    B loop

stopp:
    MOV r0, r3
    BX lr

main:
    @ Always return properly to caller (even from main)
    push {lr}
    MOV r0, #34 @bruker 5 jeg
    Bl fib
    MOV r1, r0
    ldr r0, =output_string
    BL printf
    pop {lr}
    BX lr
    
@ The 'data' section contains static data for our program
.data
output_string:
    .asciz "%d\n"
