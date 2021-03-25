lista = []
while True:
    n = int(input('Digite um número (0 para encerrar): '))
    if n == 0:
        break
    lista.append(n)
print('O maior número da lista é: ',max(lista))
