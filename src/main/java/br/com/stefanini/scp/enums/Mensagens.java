package br.com.stefanini.scp.enums;

/**
 * TODO: Colocar mensagens em um arquivo de propriedades...
 * 
 * @author leandro
 *
 */
public enum Mensagens {

	
	MSG_USUARIO_ERRO_CADASTRAR("Erro ao cadastrar usuário!"),
	MSG_USUARIO_ERRO_NOME_NAO_PREENCHIDO("Nome do usuário não preenchido!"), 
	MSG_USUARIO_ERRO_DATA_NASCIMENTO_NAO_PREENCHIDA("Data de nascimento não preenchida!"), 
	MSG_USUARIO_ERRO_DATA_NASCIMENTO_MAIOR_DATA_ATUAL("Data de nascimento maior que a data atual!"), 
	MSG_USUARIO_ERRO_CPF_NAO_PREENCHIDO("CPF não preenchido!"),
	MSG_USUARIO_ERRO_CPF_JA_CADASTRADO("CPF já cadastrado!");

	private String texto;
	
	private Mensagens(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	
}
