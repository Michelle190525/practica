# Almacenar los vectores en listas
vector1 = [1, 2, 3]
vector2 = [-1, 0, 2]

# Calcular el producto escalar
producto_escalar = sum(vector1[i] * vector2[i] for i in range(len(vector1)))

# Mostrar el resultado
print("Producto escalar:", producto_escalar)
