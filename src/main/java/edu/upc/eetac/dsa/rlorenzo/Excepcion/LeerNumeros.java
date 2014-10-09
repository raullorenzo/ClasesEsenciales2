package edu.upc.eetac.dsa.rlorenzo.Excepcion;

import java.io.*;

public class LeerNumeros {

	public static void main(String[] arg) throws BigNumberException {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		

		try {
			String fichero = System.getProperty("user.dir")
					+ "/Resources/numeros.txt";
			archivo = new File(fichero);
			fr = new FileReader(archivo);
		}

		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}

		try {
			br = new BufferedReader(fr);

			String linea;
			int numero;
			linea = br.readLine();
			while (linea != null) {

				try {
					numero = Integer.parseInt(linea);
				}

				catch (NumberFormatException e) {
					throw new RuntimeException(e);
				}

				if (numero > 1000)
					throw new BigNumberException();

				System.out.println(linea);
				linea = br.readLine();
			}
		}
		catch (IOException e)

		{
			throw new RuntimeException(e);
		}

		finally {

			try {

				if (fr != null)
					fr.close();
			}

			catch (Exception e2) {
				throw new RuntimeException(e2);
			}

		}

	}
}