#include "fft.h"

/**
 * This file contains the implementation of `fft_compute` and ancillary
 * functions.
 */

// Include for math functions and definition of PI
#include <math.h>
// Included to get access to `malloc` and `free`
#include <stdlib.h>

// Forward declaration of helper methods
void get_even(const complex* in, complex* out, const int n) {
	for(int i = 0; i < n / 2; i++) {
		// Transfer all the even indexed numbers to the output array
		out[i] = in[2 * i];
	}
}

void get_odd(const complex* in, complex* out, const int n) {
	for(int i = 0; i < n / 2; i++) {
		// Transfer all the odd indexed numbers to the output array
		out[i] = in[2 * i + 1];
	}
}
// helping function for saving twiddle-factors in memory
void create_twiddle(complex** inout, const int n) {
	for(int j = n; j >= 2; j = j/2) {
		inout[j] = malloc(sizeof(complex) * j/2);
		for(int i = 0; i < j/2; i++) {
			inout[j][i] = cexp(0 - (2. * M_PI * i) / j * I);
		}
	}
}



//Wrapper funksjon
void min_fft_compute(const complex* in, complex* out, const int n, complex** w) {
	if(n == 1) {
		out[0] = in[0];
	} else {
		const int half = n / 2;
		// First we declare and allocate arrays
		// Allocate enough room for half the input values
		complex* even = malloc(sizeof(complex) * half);
		complex* odd  = malloc(sizeof(complex) * half);
		complex* even_out = malloc(sizeof(complex) * half);
		complex* odd_out  = malloc(sizeof(complex) * half);
		// Extract even and odd indexed numbers using methods above
		get_even(in, even, n);
		get_odd(in, odd, n);
		// Recursively calculate the result for bottom and top half
		min_fft_compute(even, even_out, n / 2, w);
		min_fft_compute(odd, odd_out, n / 2, w);
		// Combine the output of the two previous recursions
		for(int i = 0; i < half; ++i) {
			const complex e = even_out[i];
			const complex o = odd_out[i];
			out[i]        = e + w[n][i] * o;
			out[i + half] = e - w[n][i] * o;
		}
		// Since we allocated room for variables we need to release
		// the memory!
		free(even);
		free(odd);
		free(even_out);
		free(odd_out);
	}
}

void fft_compute(const complex* in, complex* out, const int n) {
	//allocate memory for twiddle factors
	complex** w = malloc(sizeof(complex*) * n);
	//fill with twiddle factors
	create_twiddle(w, n);
	//call the computing function
	min_fft_compute(in, out, n, w);
	//release the memory
	free(w);

}
