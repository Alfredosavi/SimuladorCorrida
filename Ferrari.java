public class Ferrari extends VeiculoMotorizado {
	private final int movimento; // Cada Veiculo possui um nivel de mover diferente ...

	public Ferrari(String id) {
		super(id, 4, (float)1.5); // Chamando construtor da Super Classe informando (ID / quantRodas / consumo)
		this.movimento = 10; // Setando movimento do veiculo Ferrari ...
	}

	public void mover() {
		// CHECK CALIBRAGEM PNEUS
		boolean valida = false;
		for(int i=0 ; i<super.getquantRodas() ; i++) {
			if(super.getCalibragem(i) == false) {
				valida = true;
			}
		}

		if(valida == true) {
			System.out.println("Não foi possivel mover esta Ferrari (" + super.getid() + ") pois esta com pneus vazios !");
		}

		if(super.getcombustivel() >= super.getconsumo()) {
			super.setdistPercorrida(super.getdistPercorrida()+ movimento); // aumentando distancia percorrida
			super.setcombustivel(super.getcombustivel() - super.getconsumo()); // diminuindo quantidade de combustivel
			System.out.println("Ferrari (" + super.getid() + ") movida com sucesso ...");
		} else {
			System.out.println("Não foi possivel mover esta Ferrari (" + super.getid() + ") pois esta com combustivel insuficiente !");
		}
	}

	public void imprimirTrajetoria() {
		if(super.getdistPercorrida() == 0) {
			System.out.println("|" + super.getid());
		} else {
			String trajetoria = "|";
			for (int i=1 ; i<=super.getdistPercorrida() ; i++) {
				trajetoria = trajetoria + "-";
			}
			System.out.println(trajetoria + super.getid());
		}
	}
}