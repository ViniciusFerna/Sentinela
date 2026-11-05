package br.com.sentinela.model;

import java.util.ArrayList;

public class CentralMonitoramento {
	
	private Sensor[] sensores;

	public CentralMonitoramento(Sensor[] sensores) {
		this.sensores = sensores;
	}
	
	public Sensor[] getSensores() {
		return sensores;
	}
	
	public ArrayList<AlertaSeguranca> analisarLeituras(Sensor[] sensores) {
		int quantidadeSensores = sensores.length;
		
		ArrayList<AlertaSeguranca> alertas = new ArrayList<>();
		
		for(int i = 0; i < quantidadeSensores; i++) {
			switch(sensores[i].verificarStatus()) {
				case "CRITICO":
					AlertaSeguranca alertaCritico = new AlertaSeguranca(
							sensores[i],
							sensores[i].getLocalizacao(),
							"CRITICA"
					);
					alertas.add(alertaCritico);	
					break;
				case "ATENCAO":
					AlertaSeguranca alertaMedio = new AlertaSeguranca(
							sensores[i],
							sensores[i].getLocalizacao(),
							"MEDIA"
					);
					alertas.add(alertaMedio);
			}
		}
		return alertas;
	}

}
