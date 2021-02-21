Crud Utilizando as Tecnologias

	
	- Configuração do KeyCloak
		Configuração via Container Docker
		
		
	
	- Banco de Dados
		- Oracle 11g apontado em container docker
	
	
	- BackEnd(JavaEE - 7)
		- JAX-RS 2
		- EJB 3.2
		- JPA 2
		
	- FrontEnd(Angular Js)
		- Angular-JS 1.8.2
		- AngularRoute 1.8.2
		- Bootstrap 3.4
		
	
	Visão do Exemplo
		Demonstrativo de Preço de Operadoras
		Cadastramento de Telefones
		
		

	--Para rodar o KeyCloak execute o seguinte comando 
	docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin  -e KEYCLOAK_IMPORT=${PWD}//keycloack//imports//realm-export.json jboss/keycloak

	--Depois vai ser necessário importar o arquivo de configuração
	-- Ainda não fiz o compose
	
			
		

