.text
.global main

@ Main function of program
main:
    @ First load the desired Fibonacci number
    MOV r0, #13 @ N
    @ Initialize the first two numbers in the sequence
    MOV r1, #0  @ current
    MOV r2, #1  @ previous

@ Loop will do the main work calculating the Fibonacci sequence
loop:
    @ ! Implement your logic here !
    add r3, r1, r2
    MOV r1, r2 
    MOV r2, r3
    
    sub r0, #1
    cmp r0, #0
    @ Jump to exit
    ble exit
    @ Jump to start off loop
    B loop
@ To be a good citizen we branch (and exchange) on the lr register
@ to return to the caller
exit:
    BX lr
