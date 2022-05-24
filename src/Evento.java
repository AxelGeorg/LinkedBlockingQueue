import java.time.LocalDate;

public class Evento {
	public int numero;
	public String mensagem;
	public LocalDate localDate;

	public Evento(String mensagem, int numero) {
		this.mensagem = mensagem;
		this.numero = numero;
		this.localDate = LocalDate.now();
	}

	public String getMensagemCompleta() {
		return "Log " + this.numero + " - " + this.localDate.toString() + " - " + this.mensagem + "\n";
	}
}