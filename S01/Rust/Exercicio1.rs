use std::io;

fn main() {
    let mut n1_input = String::new();
    let mut n2_input = String::new();
    let mut op = String::new();

    println!("Digite o primeiro número:");
    io::stdin().read_line(&mut n1_input).expect("Failed to read line");

    println!("Digite o segundo número:");
    io::stdin().read_line(&mut n2_input).expect("Failed to read line");

    println!("Soma ou produto? (+,*)");
    io::stdin().read_line(&mut op).expect("Failed to read line");

    let number1: i32 = n1_input.trim().parse().expect("Digite um número válido");
    let number2: i32 = n2_input.trim().parse().expect("Digite um número válido");

    let res = if op.trim() == "+" {
        number1 + number2
    } else {
        number1 * number2
    };

    println!("Resultado: {}", res);
}
