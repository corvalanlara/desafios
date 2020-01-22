package cuarto;

import java.util.Collections;
import java.util.Scanner;

public class PatronesAnidados {

	public static void main(String[] args) {
			System.out.println("Elige el número del patrón a imprimir");
			System.out.print("> ");
			
			Scanner input = new Scanner(System.in);
			int opcion = input.nextInt();
			
			while (opcion > 4 || opcion < 1) {
				System.out.println("La opción es incorrecta. Ingrese nuevamente.");
				System.out.print("> ");
				opcion = input.nextInt();
			}

			
			System.out.println("¿Cuántas veces se debe imprimir?");
			System.out.println("> ");
			
			int veces = input.nextInt();
			
			while (veces <= 0) {
				System.out.println("La opción es incorrecta. Ingrese nuevamente.");
				System.out.print("> ");
				veces = input.nextInt();
			}
			
			input.close();
			
			String equis = "x";
			String asterisco = "*";
			String espacio = " ";
			String salto = "\n";
			
			if(opcion == 1) {
				String f = "";
				for(int i = 0; i < veces; i++) {
					if (i == 0 || i == veces - 1) {
						f = f + String.join("", Collections.nCopies(veces, asterisco)) + salto;
					} else {
						f = f + asterisco + String.join("", Collections.nCopies(veces - 2, espacio)) + asterisco + salto;
					}
				}
				System.out.println(f);
			} else if (opcion == 2) {
				String f = "";
                for(int i = 0; i < veces; i++) {
                    for (int j = 0; j < veces; j++) {
                            if(j == veces - 1 - i || i == 0 || i == veces - 1) {
                                    f = f + asterisco;
                            } else {
                                    f = f + espacio;
                            }
                    }
                    f = f + salto;
    }
				System.out.println(f);
			} else if (opcion == 3) {
				String f = "";

                for(int i = 0; i < veces; i++) {
                                for (int j = 0; j < veces; j++) {
                                        if(j == i || j == veces - 1 - i) {
                                                f = f + equis;
                                        } else {
                                                f = f + espacio;
                                        }
                                }
                                f = f + salto;
                }
				System.out.println(f);
			} else if(opcion == 4) {
				String f = "";

                for(int i = 0; i < veces; i++) {
                        if(i == 0) {
                                for(int j = 0; j < veces; j++) {
                                        if(j == veces - 1) {
                                        	if (veces == 1) {
                                        		f = f + asterisco;
                                        	} else {
                                                f = f + espacio;
                                        	}
                                        } else {
                                                f = f + asterisco;
                                        }
                                }
                                f = f + salto;
                        } else if(i == veces - 1) {
                                for (int j = 0; j < veces; j++) {
                                        if(j == 0) {
                                                f = f + espacio;
                                        } else {
                                                f = f + asterisco;
                                        }
                                }
                                f = f + salto;
                        } else {
                                for (int j = 0; j < veces; j++) {
                                        if(j == 0 || j == veces - 1) {
                                                f = f + espacio;
                                        } else {
                                                f = f + asterisco;
                                        }
                                }
                                f = f + salto;
                        }
                }
                System.out.print(f);
			} else {
				input.close();
				throw new java.lang.RuntimeException("WHAT THE FUCK!");
			}


	}

}
