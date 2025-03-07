numeros = {}
contador = 0

for i = 1, 100 do
  numeros[i] = math.random(0,100)
  if numeros[i] % 2 == 0 then
    contador = contador + 1
  end
end

print("Quantidade de números pares: " .. contador)

