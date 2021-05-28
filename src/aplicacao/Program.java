package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;
import model.exception.DominioException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.println("data de Entrada:(dd/MM/yyyy");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Data de saida: ");
			Date checkout = sdf.parse(sc.next());

			Reservas reserva = new Reservas(numeroQuarto, checkin, checkout);
			System.out.println("**************************reserva***************************** " + reserva);

			System.out.println("\n******************atualização de reservas*******************");
			System.out.println("novo checkin: ");
			checkin = sdf.parse(sc.next());
			System.out.println("checkout: ");
			checkout = sdf.parse(sc.next());

			Date agora = new Date();

			reserva.alterarReservas(checkin, checkout);
			System.out.println(reserva);
		}catch (ParseException e) {
			System.out.println("formato de data invalido!");
		}catch(DominioException e) {
			System.out.println(" Erro na reserva: " + e.getMessage());
		}catch(RuntimeException a) {
			System.out.println("desculpe ocorreu um erro inesperado!");
		}

		sc.close();
	}

}
