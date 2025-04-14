
class Carro
  def descrever
    "Sou um carro padrao, golzinho"
  end
end

class CarroEsportivo < Carro
  def descrever
    "Sou um carro esportivo, laferrari"
  end
end

class CarroSedan < Carro
  def descrever
    "Sou um carro sedan, aston martin"
  end
end

carro1 = Carro.new
carro2 = CarroEsportivo.new
carro3 = CarroSedan.new

puts carro1.descrever
puts carro2.descrever
puts carro3.descrever
