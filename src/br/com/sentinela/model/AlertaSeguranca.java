package br.com.sentinela.model;

public class AlertaSeguranca {
	
	private Sensor sensorOrigem;
	
	private ZonaRestrita zonaAfetada;
	
	private String severidade;
	
	private String mensagem;
	
	public AlertaSeguranca(Sensor sensorOrigem, ZonaRestrita zonaAfetada, String severidade) {
		this.sensorOrigem = sensorOrigem;
		this.zonaAfetada = zonaAfetada;
		this.severidade = severidade;
	}

	public Sensor getSensorOrigem() {
		return sensorOrigem;
	}

	public ZonaRestrita getZonaAfetada() {
		return zonaAfetada;
	}

	public String getSeveridade() {
		return severidade;
	}

	public String getMensagem() {
		return mensagem;
	}

}
