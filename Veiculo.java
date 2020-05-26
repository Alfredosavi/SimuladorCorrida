public abstract class Veiculo {
	private String id;
	private int distPercorrida;
	private Roda[] rodas;
	private int quantRodas;

	public Veiculo(String id, int quantRodas) {
		this.id = id;
		this.distPercorrida = 0;
		this.quantRodas = quantRodas;

		rodas = new Roda[quantRodas];
		for(int i=0 ; i<quantRodas ; i++) {
			this.rodas[i] = new Roda(); // construtor sem argumento recebe false para a calibragem dos pneus
		}
	}

	public String getid() {
		return (this.id);
	}

	public int getdistPercorrida() {
		return (this.distPercorrida);
	}

	public void setdistPercorrida(int dist) {
		this.distPercorrida = dist;
	}

	public int getquantRodas() {
		return (this.quantRodas);
	}

	public String toString() {
		return ("ID: " + this.id + " | Distancia Percorrida: " + this.distPercorrida + " | Quantidade de Rodas: " +
			this.quantRodas + " | calibragem Pneus: " + this.getCalibragem(0));
		// Como a calibragem dos pneus não são individuais se o 1 pneu está vazio o resto tambem está ... portanto qualquer veiculo tem pelo menos 1 pneu ... por isso o indice 0
	}

	public void setCalibragem(int i, boolean cp) {
		this.rodas[i].setCalibragem(cp);
	}

	public boolean getCalibragem(int i) {
		return (this.rodas[i].getCalibragem());
	}

	public String statusPneu(int i) {
		return (this.rodas[i].toString());
	}

	public abstract void mover();
	public abstract void imprimirTrajetoria();
}