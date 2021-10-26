#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Date    : 2021-10-26 15:26:56
# @Author  : Lars van Dartel (l.v.dartel@student.tue.nl)
# @Version : 1.0.0

import sys
import math

def get_primes(limit: int):
    """
    Returns list of prime numbers below or equal to a limit

        Parameters:
            limit (int): The upper bound
        
        Returns:
            list of primes <= limit
    """

    # Initially assume all numbers are prime
    is_prime = [True] * (limit + 1)

    # Loop over possible factors of a number
    # factors can be at max sqrt(limit)
    for factor in range(2, int(math.sqrt(limit))):
        # If the current number is prime
        if is_prime[factor]:
            # All multiples of this number are not prime
            i = factor
            while i * factor <= limit:
                is_prime[factor * i] = False
                i = i + 1

    # return list of all numbers that are prime
    return [x for x in range(2, limit+1) if is_prime[x]]
    

def is_mersenne_prime(power):
    """
    Checks if a mersenne number (Mp = 2^(power)-1) is prime using the Lucas-Lehmer primality test

        Parameters:
            power (int): the power of the mersenne number

        Returns:
            true, if the number is prime accorging to the Lucas-Lehmer primality test, false otherwise
    """

    prime = (1 << power) - 1

    # Generate Lucas-Lehmer sequence
    s = 4
    for i in range(power-2):
        s = (s*s - 2) % prime

    # If the remainder after division by the prime equals 0, the number is prime
    return s == 0

if __name__ == "__main__":
    assert len(sys.argv) == 2, f'usage: {sys.argv[0]} <limit>'

    limit = int(sys.argv[1]) # upper limit

    primes = get_primes(limit) # all primes <= limit

    # print mersenne primes
    for prime in primes:
        if is_mersenne_prime(prime):
            print(prime)