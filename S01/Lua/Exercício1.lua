numero = io.read()
numero = tonumber(numero)

local contador = 1
while contador <= 10 do
  print(numero .. " * " .. contador .. "=" .. numero * contador)
  contador = contador + 1
end
