package main

import (
	"fmt"
	"math"
)

func main() {
	var x, y, z float64
	fmt.Scan(&x, &y, &z)

	if x == 0 {
		fmt.Println("Coeficiente inválido")
		return
	}

	d := y*y - 4*x*z

	if d < 0 {
		fmt.Println("Sem raízes reais")
	} else if d == 0 {
		root := -y / (2 * x)
		fmt.Printf("Raiz única: %.2f\n", root)
	} else {
		s1 := (-y + math.Sqrt(d)) / (2 * x)
		s2 := (-y - math.Sqrt(d)) / (2 * x)
		fmt.Printf("Raízes: %.2f e %.2f\n", s1, s2)
	}
}
