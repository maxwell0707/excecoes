package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DominioException;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservas() {

	}

	public Reservas(Integer numeroQuarto, Date checkin, Date checkout) {
		Date agora = new Date();
		if (checkin.before(agora) || checkout.before(agora)) {
			throw new DominioException(" As datas  devem ser futuras");

		}
		if (!checkout.after(checkin)) {

			throw new DominioException("a data de saida dever ser apos a data de entrada");
		}
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
		// duração em milisegundos
		long diferenca = checkout.getTime() - checkin.getTime();

		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);

	}

	public void alterarReservas(Date checkinn, Date checkoout)  {

		Date agora = new Date();
		if (checkinn.before(agora) || checkoout.before(agora)) {
			throw new DominioException(" As datas de atualização  devem ser futuras");

		}
		if (!checkoout.after(checkinn)) {

			throw new DominioException("a data de saida dever ser apos a data de entrada");
		} else {
			this.checkin = checkinn;
			this.checkout = checkoout;
			
		}

	}

	@Override
	public String toString() {

		return "\nnumero do quarto: " + numeroQuarto + "\ncheckin: " + sdf.format(checkin) + "\ncheckout: "
				+ sdf.format(checkout) + "\nNoites: " + duracao();

	}

}
