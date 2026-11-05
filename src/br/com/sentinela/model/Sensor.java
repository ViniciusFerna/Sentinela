package br.com.sentinela.model;

public class Sensor {
	
	private String codigoIdentificador;
	
	private ZonaRestrita localizacao;
	
	private boolean emOperacao;
	
	private double leituraDoSensor;
	
	public Sensor(String codigoIdentificador, ZonaRestrita localizacao, boolean emOperacao) {
		this.codigoIdentificador = codigoIdentificador;
		this.localizacao = localizacao;
		this.emOperacao = emOperacao;
	}

	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public ZonaRestrita getLocalizacao() {
		return localizacao;
	}

	public boolean isEmOperacao() {
		return emOperacao;
	}
	
	public double getLeituraDoSensor() {
		return leituraDoSensor;
	}
	
	public void registrarLeituraSensor(double leitura) {
		if (leitura < 0 || leitura >= 1000000) {
			System.out.println("Erro");
		}  else {
			this.leituraDoSensor = leitura;
		}
	}
	
	public String verificarStatus() {
		
		switch(localizacao.getDescricao()) {
			case "reator":
				if(leituraDoSensor > 100) {
					return "CRITICO";
				} else if (leituraDoSensor <= 100 && leituraDoSensor > 10) {
					return "ATENCAO";
				} else {
					return "NORMAL";
				}
		}
		
		if(leituraDoSensor > 10) {
			return "CRITICO";
		} else if (leituraDoSensor <= 10 && leituraDoSensor > 0.5) {
			return "ATENCAO";
		} else {
			return "NORMAL";
		}
		
	}
	
	
	
	
	
}
