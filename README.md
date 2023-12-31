# TechChallenge 3

## Projeto do curso de Pós-Graduação da FIAP

## Grupo 50

- [Daniel Santiago](https://github.com/SantiagoDDaniel)
- [Kassiane Silva Mentz](https://github.com/kassimentz)
- [Leandro Paulino Costa](https://github.com/LeandroPC)
- [Luiz Felipe da Silva Santos](https://github.com/Felipe-3191)
- [Vitor Hugo Campos Alves](https://github.com/vitorAlves1992/)

## Fase 3 (29/08 até 06/11)

**Objetivos:**

- Documento de requisitos: [Documento de Requisitos](./Documentacao_Funcional_de_Sistema_de_Parquimetro.pdf)

   
**Entregáveis:**

Um **relatório PDF** que contenha as seguintes informações:

1. Link do GitHub com código-fonte dos serviços desenvolvidos
   - [Repositório CRUDs](https://github.com/Felipe-3191/TechChallenge3-CRUDS)
   - [Repositório Terraform + Lambdas](https://github.com/Felipe-3191/Techchallenge3-Estacionamento)
2. Documentação Técnica
3. Um Relatório Técnico descrevendo as tecnologias e ferramentas utilizadas, os desafios encontrados durante o desenvolvimento e as soluções implementadas para resolvê-los.
   



## Considerações Iniciais (Premissas)

Pressupomos que haverá uma aplicação mobile responsável por consumir os diversos serviços propostos por esse TechChallenge, portanto, essa aplicação será a fronteira e hipoteticamente os serviços serão consumidos apenas por essa aplicação, que conhecerá os métodos de acesso bem como considerará as questões de segurança e validações envolvidas.
Entedemos que como melhor prática, o Terraform criado deveria ser criado em módulos e estivesse ligado a uma esteira CI/CD, porém, respeitando o tempo e o escopo que nos foi passado, optamos por utilizar apenas um arquivo terraform, que irá provisionar toda a infraestrutura necessária



---
# Arquitetura da Aplicação - Serviços on Premise

## Registro de Condutores e Veículos / Registro de Forma de Pagamento
Em uma primeira análise, os CRUDS de registro de condutores e veículos não representam um ponto crítico no que diz respeito a capacidade de escalar da aplicação, portanto, optamos por rodar essa aplicação on premises, funcionando com Endpoints Rest e persistência em um banco relacional, conforme já foi feito no TechChallenge 2. 

Link para o repositório do GitHub que contem a implementação dos CRUDs on-premises: 
[Repositório CRUDs](https://github.com/Felipe-3191/TechChallenge3-CRUDS)

A API de implementação doss CRUDs on-premises possui uma documentação que pode ser acessada através deste endereço(http://localhost:8080/swagger-ui/index.html) quando a aplicação está online.

Abaixo, temos um PDF desta mesma documentação:
[Swagger UI.pdf](https://github.com/Felipe-3191/TechChallenge3-CRUDS/files/13260941/Swagger.UI.pdf)

Esta documentação descreve os seguintes endpoints:
## Condutor
#### [PUT] /condutor -> atualiza os dados do condutor
#### [POST] /condutor -> insere os dados do condutor
#### [GET] /condutor/buscarTodos -> busca os dados de todos os condutores com os seus veículos associados
#### [GET] /condutor/buscarTodosMin -> busca os dados de todos os condutores sem a lista de veículos associados
#### [DELETE] /condutor/{id} -> deleta os dados de um condutor em específico

## Veículo
#### [GET] /veiculo -> busca um veículo dado uma placa informada
#### [PUT] /veiculo -> atualiza os dados de um veículo existente
#### [POST] /veiculo -> insere os dados de um veículo
#### [GET] /veiculo/{id} -> busca os dados de um veículo dado um id de veículo existente
#### [DELETE] /veiculo/{id} -> deleta os dados de um veículo em específico
---
