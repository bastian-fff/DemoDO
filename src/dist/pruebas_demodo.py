# coding=utf-8
import fnmatch
import locale
import os
import pandas as pd
import subprocess
import sys


# Procedimiento que ejecuta la aplicación con los argumentos indicados y retorna la salida
def ejecutar_proceso( arg1, arg2 ):
    # Crea el proceso
    p = subprocess.Popen( cmd, stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, encoding=charset )

    # Lee los datos iniciales
    print(p.stdout.readline(), end='')
    print(p.stdout.readline(), end='')
    print(p.stdout.readline(), end='')
    print(p.stdout.readline(), end='')

    # Primer argumento
    print(p.stdout.readline(), end='')
    os.write(p.stdin.fileno(), (arg1 + "\n").encode())
    print(arg1)
    # Segundo argumento
    tmp = p.stdout.readline()
    print(tmp, end='')
    if not tmp.startswith("Ingrese"):
        return tmp
    else:
        print(arg2)
        os.write(p.stdin.fileno(), (arg2 + "\n").encode())

    # Almacena el resultado
    resultado = ""

    # Respuesta
    tmp = p.stdout.readline()

    # Flujo normal
    if tmp.strip() == "":
        print(tmp, end='')
        print(p.stdout.readline(), end='')
        print(p.stdout.readline(), end='')

        # Almacena el resultado
        resultado = resultado + p.stdout.readline()
        resultado = resultado + p.stdout.readline()
        resultado = resultado + p.stdout.readline()
        resultado = resultado + p.stdout.readline()

    # Excepción
    else:
        resultado = resultado + tmp

    return resultado

# Procedimiento que valida los resultados de las operaciones
def validar_resultados( row, texto_resultado ):
    # Plantilla del texto esperado
    texto_esperado = ""
    texto_esperado += "Suma de los argumentos:            (" + row["arg1"] + " + " + row["arg2"] + ") = _suma_\n"
    texto_esperado += "Resta de los argumentos:           (" + row["arg1"] + " - " + row["arg2"] + ") = _resta_\n"
    texto_esperado += "Producto de los argumentos:        (" + row["arg1"] + " x " + row["arg2"] + ") = _producto_\n"
    texto_esperado += "Cociente entero de los argumentos: (" + row["arg1"] + " / " + row["arg2"] + ") = _cociente_\n"

    # Reemplaza por los resultados
    texto_esperado = texto_esperado.replace("_suma_", row["suma"]).replace("_resta_", row["resta"]).replace("_producto_", row["producto"]).replace("_cociente_", row["cociente"])
    print("Resultado esperado")
    print(texto_esperado)

    # Compara
    if texto_esperado == texto_resultado:
        print("\tResultado de operaciones con " + row["arg1"] + " y " + row["arg2"] + " ---> OK")
    else:
        sys.exit("Error en prueba con " + row["arg1"] + " y " + row["arg2"])

# Procedimiento que valida los resultados de las excepciones
def validar_excepciones( row, texto_resultado ):
    # Error esperado
    print("Error esperado")
    print(row.error)
    print()

    # Compara
    if row.error in texto_resultado:
        print("\tControl de excepciones con " + row.arg1 + " y " + row.arg2 + " ---> OK")
    else:
        sys.exit(row.mensaje)



# Cambia la ruta de trabajo
os.chdir(os.path.dirname(os.path.realpath(__file__)))

# Obtiene el nombre del ejecutable
exe = fnmatch.filter(os.listdir('.'), '*.jar')[0]

# Comando para ejecutar la aplicación
cmd = "java -jar " + exe

# Obtiene el charset local
charset = locale.getdefaultlocale()[1]



# Datos de prueba para excepciones
data = [
    ["1", "0", "Validar división por cero", "java.lang.ArithmeticException"], 
    ["n", "0", "Validar ingreso de valor no numérico", "Se esperaba un numero entero y se recibio 'n'"], 
    ["0", "t", "Validar ingreso de valor no numérico", "Se esperaba un numero entero y se recibio 't'"]
]
df = pd.DataFrame(data, columns=["arg1", "arg2", "mensaje", "error"])

# Validación de excepciones
for row in df.itertuples():
    # Ejecuta el proceso
    salida = ejecutar_proceso( row.arg1, row.arg2 )

    # Resultado real
    print("Resultado real")
    print(salida)

    # Comprueba la salida
    validar_excepciones( row, salida )



# Datos de prueba para operaciones
data = [
    ["81", "9", "90", "72", "729", "9"], 
    ["45", "5", "50", "40", "225", "9"], 
    ["6", "3", "9", "3", "18", "2"], 
    ["0", "5", "5", "-5", "0", "0"]
]
df = pd.DataFrame(data, columns=["arg1", "arg2", "suma", "resta", "producto", "cociente"])

# Verificación de operaciones
for index, row in df.iterrows():
    # Ejecuta el proceso
    salida = ejecutar_proceso( row["arg1"], row["arg2"] )

    # Resultado real
    print("Resultado real")
    print(salida)

    # Comprueba la salida
    validar_resultados( row, salida )

