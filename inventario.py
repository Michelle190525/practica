import os

class Inventario:
    def __init__(self, archivo='inventario.txt'):
        self.archivo = archivo
        self.productos = {}
        self.cargar_inventario()

    # Cargar inventario desde archivo
    def cargar_inventario(self):
        if not os.path.exists(self.archivo):
            # Crear archivo si no existe
            try:
                with open(self.archivo, 'w') as f:
                    pass
                print(f"Archivo {self.archivo} creado exitosamente.")
            except PermissionError:
                print(f"Error: No se tiene permiso para crear el archivo {self.archivo}.")
            return
        
        try:
            with open(self.archivo, 'r') as f:
                for linea in f:
                    datos = linea.strip().split(',')
                    if len(datos) == 3:
                        nombre, cantidad, precio = datos
                        self.productos[nombre] = {
                            'cantidad': int(cantidad),
                            'precio': float(precio)
                        }
        except FileNotFoundError:
            print(f"Error: No se encontró el archivo {self.archivo}.")
        except Exception as e:
            print(f"Error al leer el archivo: {e}")

    # Guardar inventario en archivo
    def guardar_inventario(self):
        try:
            with open(self.archivo, 'w') as f:
                for nombre, info in self.productos.items():
                    f.write(f"{nombre},{info['cantidad']},{info['precio']}\n")
        except PermissionError:
            print(f"Error: No se tiene permiso para escribir en {self.archivo}.")
        except Exception as e:
            print(f"Error al guardar el inventario: {e}")

    # Añadir producto
    def añadir_producto(self, nombre, cantidad, precio):
        if nombre in self.productos:
            print(f"El producto {nombre} ya existe. Use actualizar_producto para modificarlo.")
            return
        self.productos[nombre] = {'cantidad': cantidad, 'precio': precio}
        self.guardar_inventario()
        print(f"Producto {nombre} añadido correctamente.")

    # Actualizar producto
    def actualizar_producto(self, nombre, cantidad=None, precio=None):
        if nombre not in self.productos:
            print(f"El producto {nombre} no existe.")
            return
        if cantidad is not None:
            self.productos[nombre]['cantidad'] = cantidad
        if precio is not None:
            self.productos[nombre]['precio'] = precio
        self.guardar_inventario()
        print(f"Producto {nombre} actualizado correctamente.")

    # Eliminar producto
    def eliminar_producto(self, nombre):
        if nombre in self.productos:
            del self.productos[nombre]
            self.guardar_inventario()
            print(f"Producto {nombre} eliminado correctamente.")
        else:
            print(f"El producto {nombre} no existe.")

    # Mostrar inventario
    def mostrar_inventario(self):
        if not self.productos:
            print("El inventario está vacío.")
        else:
            print("Inventario actual:")
            for nombre, info in self.productos.items():
                print(f"{nombre}: Cantidad = {info['cantidad']}, Precio = ${info['precio']:.2f}")
def menu():
    inv = Inventario()

    while True:
        print("\n--- Sistema de Gestión de Inventario ---")
        print("1. Añadir producto")
        print("2. Actualizar producto")
        print("3. Eliminar producto")
        print("4. Mostrar inventario")
        print("5. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == '1':
            nombre = input("Nombre del producto: ")
            cantidad = int(input("Cantidad: "))
            precio = float(input("Precio: "))
            inv.añadir_producto(nombre, cantidad, precio)
        elif opcion == '2':
            nombre = input("Nombre del producto a actualizar: ")
            cantidad = input("Nueva cantidad (dejar vacío si no cambia): ")
            precio = input("Nuevo precio (dejar vacío si no cambia): ")
            cantidad = int(cantidad) if cantidad else None
            precio = float(precio) if precio else None
            inv.actualizar_producto(nombre, cantidad, precio)
        elif opcion == '3':
            nombre = input("Nombre del producto a eliminar: ")
            inv.eliminar_producto(nombre)
        elif opcion == '4':
            inv.mostrar_inventario()
        elif opcion == '5':
            print("Saliendo del sistema...")
            break
        else:
            print("Opción no válida, intente nuevamente.")

if __name__ == "__main__":
    menu()
