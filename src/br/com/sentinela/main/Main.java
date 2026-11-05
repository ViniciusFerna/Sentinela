package br.com.sentinela.main;

import br.com.sentinela.model.AlertaSeguranca;
import br.com.sentinela.model.CentralMonitoramento;
import br.com.sentinela.model.Sensor;
import br.com.sentinela.model.ZonaRestrita;

public class Main {

	public static void main(String[] args) {
		
		//ZonaRestrita zona1 = new ZonaRestrita("ZNR-01", "Casa do Reator", 100);
		
		//System.out.println(zona1.getNivelRadiacaoAtual());
		
		//System.out.println(zona1.classificarRisco());
		
		//zona1.registrarLeituraRadiacao(4.7);
		
		//System.out.println(zona1.classificarRisco());
		
		// ----------------------------------
		
		//
		//zona1.registrarLeituraRadiacao(-5);
		
		//System.out.println(zona1.getNivelRadiacaoAtual());
		
		// ---------------------------------
		
		//ZonaRestrita zona2 = new ZonaRestrita("", "", 100);
		
		// ---------------------------------
		
		ZonaRestrita zona1 = new ZonaRestrita("ZNR-01", "reator", 100);
		ZonaRestrita zona2 = new ZonaRestrita("ZNR-02", "lado de fora", 1);
		ZonaRestrita zona3 = new ZonaRestrita("ZNR-03", "garagem", 1);
		ZonaRestrita zona4 = new ZonaRestrita("ZNR-04", "sala de seguranca", 1);
		
		Sensor sensor1 = new Sensor("sensor1", zona1, true);
		Sensor sensor2 = new Sensor("sensor2", zona1, true);
		Sensor sensor3 = new Sensor("sensor3", zona2, true);
		Sensor sensor4 = new Sensor("sensor4", zona3, true);
		Sensor sensor5 = new Sensor("sensor5", zona4, true);
		
		sensor1.registrarLeituraSensor(133); //Critico
		sensor2.registrarLeituraSensor(13); // Media
		sensor3.registrarLeituraSensor(0.42); //Normal
		sensor4.registrarLeituraSensor(10); // Media
		sensor5.registrarLeituraSensor(2.5);// Media
		
		Sensor[] sensores = {sensor1, sensor2, sensor3, sensor4, sensor5};
		
		System.out.println("----------------");
		
		CentralMonitoramento central = new CentralMonitoramento(sensores);
		
		
		// Sensor1 dispara alerta para a zona1
		// Sensor2 dispara alerta para a zona2
		// Sensor3 nao dispara alerta por estar normal
		// Sernsor 4 dispara alerta para a zona3
		// Sensor5 dispara alerta para a zona4
		for (AlertaSeguranca alerta : central.analisarLeituras(sensores)) {
			System.out.println(alerta.getSensorOrigem().getCodigoIdentificador());
		}
		
	}

}
