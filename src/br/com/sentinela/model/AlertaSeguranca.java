package br.com.sentinela.model;

public class AlertaSeguranca {
	
	private DispositivoMonitoramento sensorOrigem;
	
	private ZonaRestrita zonaAfetada;
	
	private String severidade;
	
	private String mensagem;
	
	public AlertaSeguranca(DispositivoMonitoramento sensorOrigem, ZonaRestrita zonaAfetada, String severidade) {
		this.sensorOrigem = sensorOrigem;
		this.zonaAfetada = zonaAfetada;
		this.severidade = severidade;
	}

	public DispositivoMonitoramento getSensorOrigem() {
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
