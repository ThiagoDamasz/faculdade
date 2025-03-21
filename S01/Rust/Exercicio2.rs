use std::io;

fn preenche_arr(arr: &mut [i32], x: i32) {
    for (i, elem) in arr.iter_mut().enumerate() {
        *elem = x * (i as i32);
    }
}

fn main() {
    let mut input = String::new();
    println!("Digite um número para preencher o array:");
    io::stdin().read_line(&mut input).expect("Falha ao ler entrada");

    let number: i32 = input.trim().parse().expect("Digite um número válido");

    let mut arr = [0; 10];
    preenche_arr(&mut arr, number);

    println!("Array preenchido: {:?}", arr);
}
