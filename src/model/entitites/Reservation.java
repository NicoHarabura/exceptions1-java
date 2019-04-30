package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (checkIn.after(checkOut)) {
			throw new DomainException("Check Out date must be after Check In date!");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {

		Date now = new Date();

		if (checkOut.before(now) || checkIn.before(now)) {
			throw new DomainException("Reservation dates must be future dates!");
		}
		if (checkIn.after(checkOut)) {
			throw new DomainException("Check Out date must be after Check In date!");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", CheckIn: " + sdf.format(checkIn) + ", CheckOut: " + sdf.format(checkOut)
				+ ", " + duration() + " nights.";
	}

}
