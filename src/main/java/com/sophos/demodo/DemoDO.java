package com.sophos.demodo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DemoDO {

	/* Log de eventos */
	static {
		System.setProperty("log4j2.configurationFile", "com/sophos/demodo/log4j2.xml");
	}
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Método principal
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		// Mensaje de bienvenida
		LOGGER.info("Bienvenido al módulo de aritmética básica");
		LOGGER.info("=========================================");
		LOGGER.info("");

		// Recibe el primer argumento
		LOGGER.info("Ingrese el primer argumento: ");
		final int arg1 = leerEnteroDeConsola();

		// Recibe el segundo argumento
		LOGGER.info("Ingrese el segundo argumento: ");
		final int arg2 = leerEnteroDeConsola();

		// Presenta los resultados
		LOGGER.info("");
		LOGGER.info("Resultados: ");
		LOGGER.info("----------------------------------------------------------");
		LOGGER.info("Suma de los argumentos:            (" + arg1 + " + " + arg2 + ") = " + sumar(arg1, arg2));
		LOGGER.info("Resta de los argumentos:           (" + arg1 + " - " + arg2 + ") = " + restar(arg1, arg2));
		LOGGER.info("Producto de los argumentos:        (" + arg1 + " x " + arg2 + ") = " + multiplicar(arg1, arg2));
		LOGGER.info("Cociente entero de los argumentos: (" + arg1 + " / " + arg2 + ") = " + dividir(arg1, arg2));

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
			LOGGER.fatal("Se esperaba un numero entero y se recibio '" + tmp + "'");
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
