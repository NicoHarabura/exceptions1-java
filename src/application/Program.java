package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check In Date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check Out Date: ");
		Date checkOut = sdf.parse(sc.next());
		while (checkIn.after(checkOut)) {
			System.out.println("Error in Reservation: Check Out date must be after Check In date!");
			System.out.println("Check In Date: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check Out Date: ");
			checkOut = sdf.parse(sc.next());
		}
		Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);

		System.out.println("Enter data to update reservation:");
		System.out.println("Check In Date: ");
		checkIn = sdf.parse(sc.next());
		System.out.println("Check Out Date: ");
		checkOut = sdf.parse(sc.next());

		Date now = new Date();

		while (checkOut.before(now) || checkIn.before(now)) {
			System.out.println("Error in Reservation: Reservation dates must be future dates!");
			System.out.println("Check In Date: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check Out Date: ");
			checkOut = sdf.parse(sc.next());
		}
		while (checkIn.after(checkOut)) {
			System.out.println("Error in Reservation: Check Out date must be after Check In date!");
			System.out.println("Check In Date: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check Out Date: ");
			checkOut = sdf.parse(sc.next());
			while (checkOut.before(now) || checkIn.before(now)) {
				System.out.println("Error in Reservation: Reservation dates must be future dates!");
				System.out.println("Check In Date: ");
				checkIn = sdf.parse(sc.next());
				System.out.println("Check Out Date: ");
				checkOut = sdf.parse(sc.next());
			}
		}
		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reservation: " + reservation);

		sc.close();

	}
}
