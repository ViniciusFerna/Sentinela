package br.com.sentinela.simulacao;

import br.com.sentinela.model.AlertaSeguranca;
import br.com.sentinela.model.CentralMonitoramento;
import br.com.sentinela.model.DispositivoMonitoramento;
import br.com.sentinela.model.DronePatrulha;
import br.com.sentinela.model.SensorPerimetral;
import br.com.sentinela.model.SensorRadiacao;
import br.com.sentinela.model.ZonaRestrita;

public class Simulador {
	
	public void executar() {
		testarRotinaNormal();
		testarPicoRadiacao();
		testarAcessoIndevido();
	}
	
	private void testarRotinaNormal() {
		System.out.println("Cenarios de teste:");
		System.out.println("""
				Primeiro cenario (Rotina normal)
				Todos sensores ligados e com as leituras dentro do limite,
				nenhuma violacao no perimetro e drone patrulhando sem deteccoes""");
		
		ZonaRestrita zona1 = new ZonaRestrita("ZNR-01", "reator", 100);
		ZonaRestrita zona2 = new ZonaRestrita("ZNR-02", "lado de fora", 1);
		ZonaRestrita zona3 = new ZonaRestrita("ZNR-03", "garagem", 1);
		ZonaRestrita zona4 = new ZonaRestrita("ZNR-04", "sala de seguranca", 1);
		
		ZonaRestrita[] zonas = {zona1, zona2, zona3, zona4};
		
		DronePatrulha drone = new DronePatrulha("drone", zona4);
		DispositivoMonitoramento sensor1 = new SensorRadiacao("sensor1", zona1, 9);
		DispositivoMonitoramento sensor2 = new SensorRadiacao("sensor2", zona1, 9);
		DispositivoMonitoramento sensor3 = new SensorPerimetral("sensor3", zona2, false, drone); // Construtor com mais de 3 parametros para teste apenas
		DispositivoMonitoramento sensor4 = new SensorPerimetral("sensor4", zona3, false, drone);
		
		drone.setRotaPatrulha(zonas);
		
		DispositivoMonitoramento[] sensores = {sensor1, sensor2, sensor3, sensor4, drone};
		
		System.out.println("------------------------------");
		
		CentralMonitoramento central = new CentralMonitoramento(sensores);
		
		for (AlertaSeguranca alerta : central.analisarLeituras(sensores)) {
			System.out.println(alerta.getSeveridade());
			System.out.println(alerta.getSensorOrigem().getCodigoIdentificador());
			System.out.println(alerta.getSensorOrigem().getLocalizacao().getDescricao());
			System.out.println("------------------------------");
		}
	}
	
	private void testarPicoRadiacao() {
		System.out.println("""
				Segundo cenario (Pico de radiacao)
				A zona do reator ultrapassa o limite de seguranca de radiacao,
				entao a central de monitoramento automaticamente cria e aciona alertas criticos""");
		
		ZonaRestrita zona1 = new ZonaRestrita("ZNR-01", "reator", 100);
		ZonaRestrita zona2 = new ZonaRestrita("ZNR-02", "lado de fora", 1);
		ZonaRestrita zona3 = new ZonaRestrita("ZNR-03", "garagem", 1);
		ZonaRestrita zona4 = new ZonaRestrita("ZNR-04", "sala de seguranca", 1);
		
		ZonaRestrita[] zonas = {zona1, zona2, zona3, zona4};
		
		DronePatrulha drone = new DronePatrulha("drone", zona4);
		DispositivoMonitoramento sensor1 = new SensorRadiacao("sensor1", zona1, 133);
		DispositivoMonitoramento sensor2 = new SensorRadiacao("sensor2", zona1, 122);
		DispositivoMonitoramento sensor3 = new SensorPerimetral("sensor3", zona2, false, drone); // Construtor com mais de 3 parametros para teste apenas
		DispositivoMonitoramento sensor4 = new SensorPerimetral("sensor4", zona3, false, drone);
		
		drone.setRotaPatrulha(zonas);
		
		DispositivoMonitoramento[] sensores = {sensor1, sensor2, sensor3, sensor4, drone};
		
		System.out.println("------------------------------");
		
		CentralMonitoramento central = new CentralMonitoramento(sensores);
		
		for (AlertaSeguranca alerta : central.analisarLeituras(sensores)) {
			System.out.println(alerta.getSeveridade());
			System.out.println(alerta.getSensorOrigem().getCodigoIdentificador());
			System.out.println(alerta.getSensorOrigem().getLocalizacao().getDescricao());
			System.out.println("------------------------------");
		}
		
	}
	
	private void testarAcessoIndevido() {
		System.out.println("""
				Terceiro cenario (Acesso indevido)
				Um dos sensores perimetrais da instalacao detecta uma violacao na cerca de sua area,
				entoa automaticamente aciona o drone que vai ao local e confirma a presenca de um veiculo nao identificado""");
		
		ZonaRestrita zona1 = new ZonaRestrita("ZNR-01", "reator", 100);
		ZonaRestrita zona2 = new ZonaRestrita("ZNR-02", "lado de fora", 1);
		ZonaRestrita zona3 = new ZonaRestrita("ZNR-03", "garagem", 1);
		ZonaRestrita zona4 = new ZonaRestrita("ZNR-04", "sala de seguranca", 1);
		
		ZonaRestrita[] zonas = {zona1, zona2, zona3, zona4};
		
		DronePatrulha drone = new DronePatrulha("drone", zona4);
		DispositivoMonitoramento sensor1 = new SensorRadiacao("sensor1", zona1, 6);
		DispositivoMonitoramento sensor2 = new SensorRadiacao("sensor2", zona1, 7);
		DispositivoMonitoramento sensor3 = new SensorPerimetral("sensor3", zona2, true, drone); // Construtor com mais de 3 parametros para teste apenas
		DispositivoMonitoramento sensor4 = new SensorPerimetral("sensor4", zona3, false, drone);
		
		drone.setRotaPatrulha(zonas);
		
		DispositivoMonitoramento[] sensores = {sensor1, sensor2, sensor3, sensor4, drone};
		
		System.out.println("------------------------------");
		
		CentralMonitoramento central = new CentralMonitoramento(sensores);
		
		for (AlertaSeguranca alerta : central.analisarLeituras(sensores)) {
			System.out.println(alerta.getSeveridade());
			System.out.println(alerta.getSensorOrigem().getCodigoIdentificador());
			System.out.println(alerta.getSensorOrigem().getLocalizacao().getDescricao());
			System.out.println("------------------------------");
		}
		
	}
	
	
}
