package main

import (
	"fmt"
	"math/rand"
)

func factorial(num int) int {
	if num == 0 {
		return 1
	}
	result := 1
	for i := 2; i <= num; i++ {
		result *= i
	}
	return result
}

func main() {
	randNum := rand.Intn(11)
	fact := factorial(randNum)

	fmt.Printf("Número: %d\n", randNum)
	fmt.Printf("Fatorial: %d\n", fact)
}