public class Roda {
	private boolean calibragemPneu;

	public Roda() {
		this.calibragemPneu = false;	
	}

	public Roda(boolean cp) {
		this.calibragemPneu = cp;
	}

	public void setCalibragem(boolean cp) {
		this.calibragemPneu = cp;
	}

	public boolean getCalibragem() {
		return this.calibragemPneu;
	}

	public String toString() {
		return ("Status Pneu: " + this.calibragemPneu);
	}
}