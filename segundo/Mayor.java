package segundo;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Mayor {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingrese la edad de la persona 1: ");
		String persona1 = sc.nextLine();
		System.out.print("Ingrese la edad de la persona 2: ");
		String persona2 = sc.nextLine();
		
		sc.close();
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fecha1 = df.parse(persona1);
		Date fecha2 = df.parse(persona2);

		if (fecha1.after(fecha2)) {
			System.out.println("La persona 2 es mayor. Su fecha de nacimiento (" + df.format(fecha2) + ") viene antes que la de la persona 1 (" + df.format(fecha2) + ")");
		} else if (fecha1.before(fecha2)) {
			System.out.println("La persona 1 es mayor. Su fecha de nacimiento (" + df.format(fecha1) + ") viene antes que la de la persona 2 (" + df.format(fecha2) + ")");
		} else if (fecha1.equals(fecha2)) {
			System.out.println("Tienen la misma edad. Ambos nacieron el " + df.format(fecha2));
		} else {
			System.out.println("wut?");
		}
		
	}

}
