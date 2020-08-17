package br.com.stefanini.scp.enums;

/**
 * TODO: Colocar mensagens em um arquivo de propriedades...
 * 
 * @author leandro
 *
 */
public enum Mensagens {

	
	MSG_PESSOA_ERRO_CADASTRAR("Erro ao cadastrar pessoa!"),
	MSG_PESSOA_ERRO_NOME_NAO_PREENCHIDO("Nome da pessoa não preenchido!"), 
	MSG_PESSOA_ERRO_DATA_NASCIMENTO_NAO_PREENCHIDA("Data de nascimento não preenchida!"), 
	MSG_PESSOA_ERRO_DATA_NASCIMENTO_MAIOR_DATA_ATUAL("Data de nascimento maior que a data atual!"), 
	MSG_PESSOA_ERRO_CPF_NAO_PREENCHIDO("CPF não preenchido!"),
	MSG_PESSOA_ERRO_CPF_JA_CADASTRADO("CPF já cadastrado!"),
	MSG_PESSOA_ERRO_CPF_INVALIDO("CPF inválido!"), 
	MSG_PESSOA_ERRO_EMAIL_INVALIDO("E-mail inválido!"), 
	MSG_PESSOA_SUCESSO_CADASTRO("Pessoa cadastra com sucesso!"), 
	MSG_PESSOA_SUCESSO_EXCLUSAO("Pessoa excluída com sucesso!"), 
	MSG_PESSOA_ERRO_EXCLUSAO("Erro ao excluir pessoa!"), 
	MSG_PESSOA_SUCESSO_ALTERACAO("Pessoa alterada com sucesso!"),
	MSG_PESSOA_ERRO_ALTERACAO("Erro ao alterar pessoa!"), 
	MSG_PESSOA_ERRO_CONSULTA("Erro ao consultar pessoa!");

	private String texto;
	
	private Mensagens(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	
}
