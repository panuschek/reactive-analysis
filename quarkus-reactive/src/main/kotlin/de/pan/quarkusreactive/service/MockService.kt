package de.pan.quarkusreactive.service


interface MockService {
    fun getPrimeNumbers(): Sequence<Int>
}