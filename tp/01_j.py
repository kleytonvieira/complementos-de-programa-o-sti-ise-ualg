import math
area = float(input("Digite a area a ser pintada (em metros): "))
lata = 18 * 3
total_latas = math.ceil(area / lata)
valor = 80 * total_latas
print("Total de latas a serem compradas: ", total_latas)
print("Preco total: ", valor)

#funcao de py que arredonda pra cima math ceil