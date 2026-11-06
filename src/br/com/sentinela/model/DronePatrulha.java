package br.com.sentinela.model;

public class DronePatrulha extends DispositivoMonitoramento {
	
	private ZonaRestrita[] rotaPatrulha;

	private int bateriaPercentual;
	
	private boolean deteccaoDeViolacao; // Camera simulada. Violacao == true

	public DronePatrulha(String codigoIdentificador, ZonaRestrita baseCarregamento) {
		super(codigoIdentificador, baseCarregamento);
		this.deteccaoDeViolacao = false;
	}
	
	public void setRotaPatrulha(ZonaRestrita[] rotaPatrulha) {
		this.rotaPatrulha = rotaPatrulha;
	}
	
	public ZonaRestrita[] getRotaPatrulha() {
		return rotaPatrulha;
	}

	public int getBateriaPercentual() {
		return bateriaPercentual;
	}

	public boolean isDeteccaoDeViolacao() {
		return deteccaoDeViolacao;
	}


	@Override
	public String verificarStatus() { //Realiza a patrulha nas areas designadas e caso haja alguma violacao em uma area, retorna a area em questao
		int quantidadePontosDeControle = rotaPatrulha.length;
				
			for (int i = 0; i < quantidadePontosDeControle; i++) {
				if(rotaPatrulha[i].getViolacaoNoPerimetro() == true) {
					System.out.println("Violacao no perimetro da zona: ".concat(rotaPatrulha[i].getIdentificador()));
					System.out.println("------------------------------");
					return "CRITICO";
				}
			}
				
			return "NORMAL";
		
	}
	
	
	public String enviarDroneParaPerimetro(ZonaRestrita localizacao) {
		int quantidadePontosDeControle = rotaPatrulha.length;
		
		for (int i = 0; i < quantidadePontosDeControle; i++) {
			if (rotaPatrulha[i] == localizacao) {
				System.out.println("Drone enviado para: ".concat(localizacao.getIdentificador()));
				System.out.println("Violacao confirmada, veiculo nao identificado em area restrita");
				return "CRITICO";
			}
		}
		
		return "Local nao encontrado";
	}


}
