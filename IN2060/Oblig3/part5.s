@ The two numbers we want to add
num1:   .word   0x3f800000
num2:   .word   0x3f800000

.text
.global main
main:
    @ Load numbers
    LDR r0, num1
    LDR r1, num2
    @ ! Perform addition here !
    
    ldr r10, =0x7f800000
    and r3, r0, r10
    and r4, r1, r10
    cmp r3, r4
    
    
    movcc r2, r0
    movcc r0, r1
    movcc r1, r2
    
    andcc r3, r0, r10
    andcc r4, r1, r10
   
    mov r3, r3, lsr #23
    mov r4, r4, lsr #23
    
    sub r2, r3, r4
    ldr r10, = 0x007fffff
    and r4, r0, r10
    and r5, r1, r10
    ldr r10, = 0x00800000
    orr r4, r4, r10
    orr r5, r5, r10
    mov r5, r5, lsr r2
    
    
    add r4, r4, r5
    
    
    @ When done, return
    mov r0, r4
    mov r0, #0
    BX lr
