package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try{
		System.out.println("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check In Date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check Out Date: ");
		Date checkOut = sdf.parse(sc.next());
		
		Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);

		System.out.println("Enter data to update reservation:");
		System.out.println("Check In Date: ");
		checkIn = sdf.parse(sc.next());
		System.out.println("Check Out Date: ");
		checkOut = sdf.parse(sc.next());

		reservation.updateDates(checkIn, checkOut);

		System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e){
		System.out.println("Invalid date format!");
		}
		catch (DomainException e){
			System.out.println("Error: " + e.getMessage());
			
		}
		catch (Exception e){
			System.out.println("Unexppected error");
		}

		sc.close();

	}
}
