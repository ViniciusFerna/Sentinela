package br.com.sentinela.model;

public abstract class DispositivoMonitoramento {
	
	private String codigoIdentificador;
	
	private ZonaRestrita localizacao;
	
	private boolean emOperacao;
	
	public DispositivoMonitoramento(String codigoIdentificador, ZonaRestrita localizacao) {
		this.codigoIdentificador = codigoIdentificador;
		this.localizacao = localizacao;
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
	
	
	public abstract String verificarStatus();

	
}