num = int(input('Digite um número para calcular: '))
aux = int(input('Digite o número que deseja (0 a 10): '))
print('Tabuada de {}'.format(num))
while aux <= 10:
    print('{0} X {1} = {2}'.format(aux, num, (aux*num)))
    break
#  aux = aux + 1
