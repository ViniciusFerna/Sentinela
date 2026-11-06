package br.com.sentinela.model;

public class ZonaRestrita {

	private String identificador;
	
	private String descricao;
	
	private double limiteRadiacao;
	
	private double nivelRadiacaoAtual;
	
	private boolean violacaoNoPerimetro;
	
	public ZonaRestrita(String identificador, String descricao, double limiteRadiacao) {
		this.setIdentificador(identificador);
		this.setDescricao(descricao);
		this.setLimiteRadiacao(limiteRadiacao);
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public double getLimiteRadiacao() {
		return limiteRadiacao;
	}

	public double getNivelRadiacaoAtual() {
		return nivelRadiacaoAtual;
	}
	
	public boolean getViolacaoNoPerimetro() {
		return violacaoNoPerimetro;
	}
	
	public void setViolacaoNoPerimetro(boolean violacao) {
		this.violacaoNoPerimetro = violacao;
	}
	
	private void setIdentificador(String identificador) {
		if (identificador.length() < 5) {
			throw new IllegalArgumentException("Erro");
		} else {
			this.identificador = identificador;
		}
	}
	
	private void setDescricao(String descricao) {
		if (descricao.length() < 4) {
			throw new IllegalArgumentException("Erro");
		} else {
			this.descricao = descricao;
		}
	}
	
	private void setLimiteRadiacao(double limiteRadiacao) {
		if (limiteRadiacao < 0 || limiteRadiacao >= 1000000) {
			System.out.println("Erro");
		}  else {
			this.limiteRadiacao = limiteRadiacao;
		}
	}

	public void registrarLeituraRadiacao(double leitura) {
		if (leitura < 0 || leitura >= 1000000) {
			System.out.println("Erro");
		}  else {
			this.nivelRadiacaoAtual = leitura;
		}
	}
	
	public String classificarRisco() {
		if (nivelRadiacaoAtual >= 10) {
			return ("CRITICO");
		} else if (nivelRadiacaoAtual < 10 && nivelRadiacaoAtual > 0.50) {
			return("ATENCAO");
		} else {
			return ("NORMAL");
		}
	}
	
	
}
