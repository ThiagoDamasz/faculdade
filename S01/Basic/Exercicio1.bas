10 INPUT "Entre com o valor a: "; A
20 INPUT "Entre com o valor b: "; B
30 INPUT "Entre com o valor c: "; C

40 LET DELTA = (B * B) - (4 * A * C)

50 IF DELTA < 0 THEN GOTO 120 ELSE GOTO 60

60 LET X1 = (-B + SQR(DELTA)) / (2 * A)
70 LET X2 = (-B - SQR(DELTA)) / (2 * A)

80 PRINT "O Valor das Raízer está abaixo"
90 PRINT X1
100 PRINT X2
110 END

120 PRINT "Não há raízes reais"