import math

# Solicitar la muestra de números
entrada = input("Ingrese una muestra de números separados por comas: ")

# Convertir la entrada en una lista de números
numeros = [float(x) for x in entrada.split(",")]

# Calcular la media
media = sum(numeros) / len(numeros)

# Calcular la desviación típica
varianza = sum((x - media) ** 2 for x in numeros) / len(numeros)
desviacion_tipica = math.sqrt(varianza)

# Mostrar resultados
print("Media:", media)
print("Desviación típica:", desviacion_tipica)
