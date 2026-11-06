package br.com.sentinela.model;

public class SensorPerimetral extends DispositivoMonitoramento {
	
	private ZonaRestrita setorVigiado;
	
	private boolean cercaViolada;
	
	private DronePatrulha drone;
	
	public SensorPerimetral(String codigoIdentificador, ZonaRestrita localizacao, boolean cercaViolada, DronePatrulha drone) {
		super(codigoIdentificador, localizacao);
		this.setorVigiado = localizacao;
		this.cercaViolada = cercaViolada;
		this.drone = drone;
	}

	public ZonaRestrita getSetorVigiado() {
		return setorVigiado;
	}

	public boolean isCercaViolada() {
		return cercaViolada;
	}
	
	
	public String verificarStatus() {
		if (this.cercaViolada == true) {
			setorVigiado.setViolacaoNoPerimetro(true);
			drone.enviarDroneParaPerimetro(setorVigiado);
			return "CRITICO";
		} else {
			return "NORMAL";
		}
		
	}
	
}
