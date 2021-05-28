package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.println("data de Entrada:(dd/MM/yyyy");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Data de saida: ");
		Date checkout= sdf.parse(sc.next());
		
		if(!checkout.after(checkin)){
			System.out.println("a data de saida dever ser apos a data de entrada");
		} else {
			Reservas reserva = new Reservas(numeroQuarto,checkin,checkout);
			System.out.println("**************************reserva***************************** " +  reserva);
		
			System.out.println("atualização de reservas");
			System.out.println("novo checkin: ");
			checkin =sdf.parse(sc.next());
			System.out.println("checkout: ");
			checkout = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(checkin.before(agora) || checkout.before(agora)) {
				System.out.println(" As datas de atualização  devem ser futuras");
			}else if(!checkout.after(checkin)){
				System.out.println("a data de saida dever ser apos a data de entrada");
			}else {
			
			reserva.alterarReservas(checkin, checkout);
			 
		System.out.println(reserva);
			}
		
		}
		
		
		
		 
		
	}

}
