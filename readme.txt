
                                 scp 

 Requisitos
 =========================
 
 - Tomcat 9
 - Java 8
 
 
 
 
 Deploy da aplicação
 =========================

 Executar o comando:

  mvn compile tomcat:run

Aplicação ira rodar na URL:
 
  http://localhost:9090/scp

Para rodar em standalone container, rodar o comando:

  mvn package

Depois fazer o deploy no servidor.



