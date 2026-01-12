# Pedir una palabra al usuario
palabra = input("Ingrese una palabra: ").lower()

# Verificar si es palíndromo
if palabra == palabra[::-1]:
    print("La palabra es un palíndromo")
else:
    print("La palabra no es un palíndromo")
