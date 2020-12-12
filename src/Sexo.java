public enum Sexo {
	MASCULINO ("M"), 
	FEMININO ("F");
		
	private final String sigla;
	
	Sexo(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSexo() {
		return sigla;
	}
}
