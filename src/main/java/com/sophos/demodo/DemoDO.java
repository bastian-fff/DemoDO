package com.sophos.demodo;

import java.util.Scanner;

public class DemoDO {

	public static void main(String[] args) {
		System.out.println("Bienvenido al modulo de aritmetica basica");
		System.out.println();
		System.out.println("Ingrese el primer argumento: ");
		final Scanner scanner = new Scanner(System.in);
		final int arg1 = scanner.nextInt();
		System.out.println("Ingrese el segundo argumento: ");
		final int arg2 = scanner.nextInt();

		System.out.println();
		System.out.println("Resultados");
		System.out.println("Suma de los argumentos:            " + sumar(arg1, arg2));
		System.out.println("Resta de los argumentos:           " + restar(arg1, arg2));
		System.out.println("Producto de los argumentos:        " + multiplicar(arg1, arg2));
		System.out.println("Cociente entero de los argumentos: " + dividir(arg1, arg2));
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
