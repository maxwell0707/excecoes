package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservas() {
		
	}
	public Reservas(Integer numeroQuarto, Date checkin, Date checkout) {
		super();
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getCheckin() {
		return checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	
	public long duracao() {
		//duração em milisegundos
		long diferenca = checkout.getTime() - checkin.getTime();
		
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
				
	}
	
	public void alterarReservas(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout =checkout;
		
	}
	@Override
	public String toString() {
		
		return "\nnumero do quarto: " 
				+numeroQuarto
				+"\ncheckin: "
				+sdf.format(checkin)
				+"\ncheckout: "
				+sdf.format(checkout)
				+"\nNoites: "
				+ duracao();
				
	}
	
	
	
	

}
