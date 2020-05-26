public class Bicicleta extends Veiculo {
	private final int movimento; // Cada Veiculo possui um nivel de mover diferente ...

	public Bicicleta(String id) {
		super(id, 2); // 2 pois é duas rodas ...
		this.movimento = 1; // setando movimento do veiculo Bicicleta ...
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
			System.out.println("");
			System.out.println("Não foi possivel mover " + super.getid() + " (Pneus vazios) ... ");
		} else {
			super.setdistPercorrida(super.getdistPercorrida() + movimento);
			System.out.println("Bicicleta (" + super.getid() + ") movida com sucesso ...");
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