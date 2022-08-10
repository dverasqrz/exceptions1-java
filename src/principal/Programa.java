package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (checkin.after(checkout)) {
			System.out.println("Error in reservation: checkout deve ser depois do checkin");
		}
		else {
			Reserva rsv = new Reserva(number, checkin, checkout);
			System.out.println("Reservation: " + rsv);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkinUP = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkoutUP = sdf.parse(sc.next());
			rsv.updateDates(checkinUP, checkoutUP);
			System.out.println("Reservation: " + rsv);
		}
		
		
		sc.close();

	}

}
