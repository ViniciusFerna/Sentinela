package br.com.sentinela.model;

public class SensorRadiacao extends DispositivoMonitoramento {
	
	private double leituraAtual;
	
	private double limiteSeguranca;

	public SensorRadiacao(String codigoIdentificador, ZonaRestrita localizacao, double leituraAtual) {
		super(codigoIdentificador, localizacao);
		this.leituraAtual = leituraAtual;
	}
	
	public double getLeituraAtual() {
		return leituraAtual;
	}

	public double getLimiteSeguranca() {
		return limiteSeguranca;
	}
	
	public void registrarLeituraSensor(double leitura) {
		if (leitura < 0 || leitura >= 1000000) {
			System.out.println("Erro");
		}  else {
			this.leituraAtual = leitura;
		}
	}
	
	public String verificarStatus() {
		
		switch(getLocalizacao().getDescricao()) {
			case "reator":
				if(getLeituraAtual() > 100) {
					return "CRITICO";
				} else if (getLeituraAtual() <= 100 && getLeituraAtual() > 10) {
					return "ATENCAO";
				} else {
					return "NORMAL";
				}
		}
		
		if(getLeituraAtual() > 10) {
			return "CRITICO";
		} else if (getLeituraAtual() <= 10 && getLeituraAtual() > 0.5) {
			return "ATENCAO";
		} else {
			return "NORMAL";
		}
		
	}
	

}
