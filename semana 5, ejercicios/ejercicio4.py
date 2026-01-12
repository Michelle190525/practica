# Pedir una palabra al usuario
palabra = input("Ingrese una palabra: ").lower()

# Inicializar contadores
vocales = {
    "a": 0,
    "e": 0,
    "i": 0,
    "o": 0,
    "u": 0
}

# Contar las vocales
for letra in palabra:
    if letra in vocales:
        vocales[letra] += 1

# Mostrar resultados
for vocal, cantidad in vocales.items():
    print(f"La vocal '{vocal}' aparece {cantidad} veces")
