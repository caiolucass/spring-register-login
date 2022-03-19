# Spring-Register-Login

## Features

> Registrar usuario e seu(s) respectivo(s) cargo(s).

> Validar e efetuar o login do usuario.

Aplicacao feita utilizando Spring e o banco de dados MySql5 implementanto funcionalidades como:

### Registration :heavy_check_mark:

O registro e feito utilizando a confirmacao da senha e um auto login atraves 
de um token gerado para o acesso do usuario. Cada usuario podera ter varios cargos
e varios cargos podem estar atribuidos a diversos usuarios "ManyToMany".

### Login :heavy_check_mark:

O login e realizado somente quando esse token for marcado como "authenticated",
caso contrario o login ira falhar.


### Validation :heavy_check_mark:

A validacao dos campos como userName e password sao feitas atraves da classe
"validator", na qual toda a regra de validacao e implementada nela.

## DevTools :hammer:
> MySQL5 :heavy_check_mark:

> Maven :heavy_check_mark:

> Lombok :heavy_check_mark:

> JPA :heavy_check_mark:

> Security :heavy_check_mark:

> Devtools :heavy_check_mark:

> Starter-web :heavy_check_mark:

 ### Docker :warning:  
> Ainda irei criar o ambiente do banco (MySql) no Docker e os arquivos
> DockerFile, docker-compose.yml


## Front-end :warning: 

O front end tambem ira ser implementdo em breve, visto que o controller ja esta pronto. E que eu
possuo dificuldade com front mesmo :joy: .






