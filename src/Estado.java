public enum Estado {
	Acre ("AC"),
	Alagoas ("AL"),
	Amapa ("AP"),
	Amazonas ("AM"),
	Bahia ("BA"),
	Ceara ("CE"),
	Distrito_Federal ("DF"),
	Espirito_Santo ("ES"),
	Goias ("GO"),
	Maranhao ("MA"),
	Mato_Grosso ("MT"),
	Mato_Grosso_do_Sul ("MS"),
	Minas_Gerais ("MG"),
	Para ("PA"),
	Paraiba ("PB"),
	Parana ("PR"),
	Pernambuco ("PE"),
	Piaui ("PI"),
	Rio_de_Janeiro ("RJ"),
	Rio_Grande_do_Norte ("RN"),
	Rio_Grande_do_Sul ("RS"),
	Rondonia ("RO"),
	Roraima ("RR"),
	Santa_Catarina ("SC"),
	Sao_Paulo ("SP"),
	Sergipe ("SE"),
	Tocantins ("TO");
	
	private final String sigla;
	
	Estado(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
}
