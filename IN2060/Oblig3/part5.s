@ The two numbers we want to add
num1:   .word   0x40000000
num2:   .word   0x3f800000

.text
.global main
main:
    @ Load numbers
    LDR r1, num1
    LDR r2, num2
    @ ! Perform addition here !
    
    @10000000011111111111111111111111 -> 0x807fffff #hente exponent
	@så
	@11111111100000000000000000000000 -> 0xff800000 #hente decimal
	@så
	@00000000010000000000000000000000 -> 0x00800000 #exponent !=0, legge til 1 på decimal
	@tall med 1tall i eksponenten
	@bruke noe rart som 0x010000000

	ldr r10, =0x807fffff
	BIC r1, r1, r10 @inverterer tallet i r10 og ender det med verdien i r1
	BIC r2, r2, r10 @henter exponent

	@bitskift til exponent ligger i minst signifikante bitplasser

	lsr r1, r1, #23
	lsr r2, r2, #23

	@henter ut decimal
	ldr r10, =0xff800000
	@laster tallene på nytt
	ldr r3, num1
	ldr r4, num2

	BIC r3, r3, r10
	BIC r4, r4, r10

	ldr r10, =0x00800000

	@compare test

	cmp r1, #0
	Beq andresjekk 
	add r3, r3, r10

	andresjekk:

	cmp r2, #0
	beq TrengerIkke
	add r4, r4, r10

	@trekke minste eksponent fra største
	TrengerIkke:
	cmp r1, r2
	bgt copy_r1
	@lagre verdien til største
	mov r5, r2
	sub r2, r2, r1
	b fin

	copy_r1:
	mov r5, r1
	sub r2, r1, r2

	fin:
	ldr r6, num1
	ldr r7, num2
	cmp r6, r7
	blt bs_r2
	lsr r4, r4, r2
	b bs_r4

	bs_r2:
	lsr r3, r3, r2

	bs_r4:
	add r3, r3, r4

	@TIME TO NORMALISE
	ldr r10, =0x01000000
	cmp r3, r10
	blt nestenFerdig

	ldr r8, =0x00800000
	ldr r10, =0xff7fffff
	skiftetid:
	mov r9, r3
	BIC r9, r9, r10
	cmp r9, r8
	beq nestenFerdig
	lsr r3, #1
	add r5, r5, #1
	b skiftetid

	@Kan legge sammen hvis good? nei må gjøre noe mer?

	nestenFerdig:
	@henter exponentene igjen for å sammenlikne
	ldr r10, =0x807fffff
	ldr r8, num1
	ldr r9, num2

	BIC r8, r8, r10 
	BIC r9, r9, r10

	cmp r8, #0
	bne subtract
	cmp r9, #0
	bne subtract
	b end

	subtract:
	ldr r10, =0x00800000
	sub r3, r3, r10 


	end:
	@Legge sammen

	orr r0, r5, r3
	BX lr
