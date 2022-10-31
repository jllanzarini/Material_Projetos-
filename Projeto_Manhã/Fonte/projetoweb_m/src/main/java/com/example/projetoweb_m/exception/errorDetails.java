package com.example.projetoweb_m.exception;

import java.util.Date;

public class errorDetails {
	private Date data;
	private String mensagem;
	private String detalhes;
	
	public errorDetails(Date data, String mensagem, String detalhes) {
		super();
		this.data = data;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
		}

		public Date getData() {
			return data;
		}
	
		public void setData(Date data) {
			this.data = data;
		}
	
		public String getMensagem() {
			return mensagem;
		}
	
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
	
		public String getDetalhes() {
			return detalhes;
		}
	
		public void setDetalhes(String detalhes) {
			this.detalhes = detalhes;
		}
}
