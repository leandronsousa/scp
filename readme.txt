 Requisitos
 =========================
 
 - Tomcat 9
 - Java 8
 
  
 Deploy da aplicação
 =========================

  Com o Tomcat sendo rodando. 
  Dentro da pasta do projeto. Executar o comando:
 
  mvn clean install tomcat7:deploy
  
  *O usuário do tomcat deve ter a role: manager-script habilitada no arquivo tomcat-users.xml
  
  Exemplo:
  
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<role rolename="manager-jmx"/>
	<role rolename="manager-status"/>
	<role rolename="admin-gui"/>
	<user username="admin" password="admin" roles="manager-gui,manager-script,admin-gui" />
  
  *O arquivo settings.xml da pasta /conf do Maven deve ter o usuário do Tomcat configurado
  
  Exemplo:
  
    <server>
		<id>TomcatServer</id>
		<username>admin</username>
		<password>admin</password>
	</server>

  *Aplicação ira rodar na URL: http://localhost:8080/scp


Deploy da aplicação standalone
 ================================

  Dentro da pasta do projeto. Executar o comando:

  mvn clean install
  
  Depois fazer o deploy do arquivo /target/scp.war no Tomcat  em http://localhost:8080/manager/html/.

  *Aplicação ira rodar na URL: http://localhost:8080/scp

