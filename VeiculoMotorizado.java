public abstract class VeiculoMotorizado extends Veiculo {
	private float combustivel;
	private float consumo; // Cada Veiculo Motorizado possui um consumo ...

	public VeiculoMotorizado(String id, int quantrodas, float consumo) {
		super(id, quantrodas); // chamando construtor de Veiculo ... informando ID/quantRodas
		this.combustivel = 0;
		this.consumo = consumo;
	}

	public void abastecer(float l) {
		this.combustivel = (l + this.combustivel);
	}

	public float getcombustivel() {
		return (this.combustivel);
	}

	public void setcombustivel(float l) {
		this.combustivel = l;
	} 

	public float getconsumo() {
		return (this.consumo);
	}
}