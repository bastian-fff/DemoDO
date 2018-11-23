package com.sophos.demodo;

import java.util.Scanner;

public class DemoDO {

	/**
	 * Método principal
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		// Mensaje de bienvenida
		System.out.println("Bienvenido al modulo de aritmetica basica");
		System.out.println("=========================================");
		System.out.println();

		// Recibe el primer argumento
		System.out.println("Ingrese el primer argumento: ");
		final int arg1 = leerEnteroDeConsola();

		// Recibe el segundo argumento
		System.out.println("Ingrese el segundo argumento: ");
		final int arg2 = leerEnteroDeConsola();

		// Presenta los resultados
		System.out.println();
		System.out.println("Resultados");
		System.out.println("----------------------------------------------------------");
		System.out.println("Suma de los argumentos:            (" + arg1 + " + " + arg2 + ") = " + sumar(arg1, arg2));
		System.out.println("Resta de los argumentos:           (" + arg1 + " - " + arg2 + ") = " + restar(arg1, arg2));
		System.out.println("Producto de los argumentos:        (" + arg1 + " x " + arg2 + ") = " + multiplicar(arg1, arg2));
		System.out.println("Cociente entero de los argumentos: (" + arg1 + " / " + arg2 + ") = " + dividir(arg1, arg2));

		// Sale
		System.exit(0);
	}

	/**
	 * Procedimiento que lee un número entero de la consola y lo retorna
	 * @return el número entero ingresado por el usuario
	 */
	public static int leerEnteroDeConsola() {
		// Configura el scanner de la línea de comandos
		final Scanner scanner = new Scanner(System.in);

		// Lee lo ingresado por el usuario
		final String tmp = scanner.next();

		// Valida si es un entero y lo retorna
		try {
			return Integer.parseInt(tmp);
		} catch (NumberFormatException nfe) {
			System.err.println("Se esperaba un numero entero y se recibio '" + tmp + "'");
			System.exit(0);
			return 0;
		}
	}

	/**
	 * Procedimiento que suma dos enteros
	 * @param arg1 argumento 1
	 * @param arg2 argumento 2
	 * @return la suma de los argumentos
	 */
	public static int sumar(int arg1, int arg2) {
		return arg1 + arg2;
	}

	/**
	 * Procedimiento que sustrae dos enteros
	 * @param arg1 argumento 1
	 * @param arg2 argumento 2
	 * @return la sustracción de los argumentos
	 */
	public static int restar(int arg1, int arg2) {
		return arg1 - arg2;
	}

	/**
	 * Procedimiento que multiplica dos enteros
	 * @param arg1 argumento 1
	 * @param arg2 argumento 2
	 * @return el producto de los argumentos
	 */
	public static int multiplicar(int arg1, int arg2) {
		return arg1 * arg2;
	}

	/**
	 * Procedimiento que divide dos enteros
	 * @param dividendo dividendo
	 * @param divisor divisor
	 * @return el cociente entero de la división de los argumentos
	 */
	public static int dividir(int dividendo, int divisor) {
		if(divisor == 0) {
			throw new ArithmeticException("División por cero");
		}
		return dividendo / divisor;
	}

}
