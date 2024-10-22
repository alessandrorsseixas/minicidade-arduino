1. Introdução
Este documento descreve a visão do projeto de automação de uma mini cidade com geração de energia solar e eólica, controlada via Arduino e integrando um sistema web. A cidade será composta por casas automatizadas, um carro movido por sensores e câmeras, e geração de energia eólica e solar para alimentar todo o sistema. O projeto envolve a criação de APIs em Spring Boot, um sistema de microfrontends em Angular e Vue, e aplicativos móveis (Android e iOS), além de microserviços para notificação e controle de dispositivos, utilizando RabbitMQ para comunicação e Redis para cache.

2. Objetivos
Criar um sistema web com Microfrontends (Angular e Vue) para monitoramento e controle da cidade.
Desenvolver aplicativos móveis Android e iOS que integrem o controle da cidade.
Gerar energia renovável (solar e eólica) para alimentar as casas e o carro da mini cidade.
Implementar uma arquitetura de microserviços para gerenciamento de energia, controle de dispositivos e notificações.
Integração com notificações (E-mail, SMS, Push, WhatsApp, Alexa).
Utilização de RabbitMQ para comunicação entre microserviços e Redis como cache para otimização de dados.
3. Escopo
Sistema Web (Microfrontends): Interface para monitoramento e controle da cidade, utilizando Angular e Vue.
Usina Solar e Eólica: Gerar energia para as casas e carregar o carro.
Carro Automatizado: Controlado por sensores e câmeras, movendo-se pela cidade.
Casas Automatizadas: Iluminação e dispositivos controlados remotamente.
Microserviços: API's Spring Boot para controle de energia, casas, carro e notificações.
Aplicativos Móveis (Android e iOS): Controle da cidade via dispositivos móveis.
Notificações: Sistema de notificações via E-mail, SMS, Push, WhatsApp e Alexa.
Cache: Utilização de Redis para otimizar leituras e escritas dos dados de dispositivos.
Fila de Mensagens: RabbitMQ para comunicação entre microserviços.
4. Arquitetura do Sistema
4.1 Descrição Geral
O sistema será composto por uma camada de microfrontends (Angular e Vue), aplicativos móveis Android/iOS, e microserviços que operam em uma infraestrutura distribuída. Utiliza-se RabbitMQ para comunicação assíncrona entre microserviços e Redis como cache de dados.

4.2 Componentes Principais
Microfrontends (Angular e Vue):
A aplicação web será dividida em dois microfrontends: um em Angular para monitoramento da cidade e outro em Vue para controle e visualização detalhada dos dispositivos.
Aplicativos Móveis (Android e iOS):
Aplicativos móveis nativos para controlar os dispositivos da cidade, visualização da geração de energia, status do carro e das casas.
Microserviço de Energia:
Gerencia a energia gerada pelas fontes solar e eólica.
Controla o estado da bateria e a distribuição de energia para casas e carro.
Microserviço de Controle da Casa:
Controla dispositivos nas casas (luzes, temperatura, tomadas) e exibe status de consumo de energia.
Microserviço de Controle do Carro:
Gerencia o movimento do carro baseado em sensores e câmeras, além de monitorar a carga da bateria do carro.
Microserviço de Notificação:
Responsável por enviar notificações via E-mail, SMS, Push, WhatsApp e Alexa.
Microserviço de Autenticação:
Gerencia login e autenticação dos usuários no sistema.
Implementa Single Sign-On (SSO) para todos os microfrontends e aplicativos móveis.
Microserviço de Monitoramento:
Monitora o status geral da cidade (geração de energia, estado das casas, etc.), enviando dados em tempo real.
Cache Redis:
Armazena temporariamente o status dos dispositivos e dados de geração de energia, melhorando a performance.
RabbitMQ:
Gerencia a comunicação assíncrona entre os microserviços.
4.3 Desenho da Arquitetura (Plain Text)
plaintext
Copiar código
+------------------------------------------------------------+
|                           Usuário                          |
|  (Navegador Web, App Android/iOS, Alexa, WhatsApp, etc.)    |
+------------------------------------------------------------+
                              |
                    HTTP Request / Mensagem
                              |
                              v
+------------------------------------------------------------+
|                     API Gateway                            |
+------------------------------------------------------------+
                |                           |
                v                           v
+-----------------------------+    +-----------------------------+
| Microfrontend Angular        |    | Microfrontend Vue            |
| (Monitoramento da cidade)    |    | (Controle detalhado)         |
+-----------------------------+    +-----------------------------+
                |                           |
                v                           v
+------------------------------------------------------------+
|                     RabbitMQ (Mensageria)                  |
+------------------------------------------------------------+
                |                           |
                v                           v
+-----------------------------+    +-----------------------------+
| Microserviço de Energia      |    | Microserviço de Controle     |
| (Spring Boot)                |    | da Casa (Spring Boot)        |
+-----------------------------+    +-----------------------------+
                |                           |
                v                           v
+-----------------------------+    +-----------------------------+
| Microserviço de Controle     |    | Microserviço de Notificação  |
| do Carro (Spring Boot)       |    | (E-mail, SMS, Push, Alexa)   |
+-----------------------------+    +-----------------------------+
                |                           |
                v                           v
+-----------------------------+    +-----------------------------+
| Redis (Cache)               |    | Banco de Dados Centralizado  |
+-----------------------------+    | (Armazenamento de Dados de   |
                |                   | Sensores, Controle, etc.)   |
                v                   +-----------------------------+
+------------------------------------------------------------+
|                    Aplicativos Móveis                     |
|        (Android, iOS - Controle dos dispositivos)          |
+------------------------------------------------------------+
5. Equipamentos Necessários (Fase 1: Energia Solar e Eólica)
Arduino Uno R3: Controle dos sistemas locais nas casas e do carro.
Turbina Eólica: Pequeno gerador eólico para geração de energia.
Painéis Solares: Mini painéis solares para captar energia.
Controlador de Carga Híbrido: Gerencia a carga das baterias a partir das fontes solar e eólica.
Bateria de Armazenamento: Armazena a energia gerada.
Sensores de Corrente/Tensão: Monitoram o uso e a geração de energia.
Servidor Spring Boot: Hospeda os microserviços.
RabbitMQ Server: Gerencia a comunicação entre os microserviços.
Redis Server: Armazena cache.
Smartphones/Tablet: Para controlar e visualizar o sistema através dos aplicativos móveis.
6. Tecnologias Utilizadas
Spring Boot: Desenvolvimento de microserviços.
Microfrontends (Angular, Vue): Sistema web distribuído em microfrontends.
RabbitMQ: Comunicação entre microserviços.
Redis: Cache de dados para otimização.
Arduino Uno R3: Controle dos dispositivos físicos.
Aplicativos Android e iOS: Desenvolvimento de aplicativos móveis para controle.
MySQL/PostgreSQL: Armazenamento de dados.
APIs de Integração: Para integração com sistemas de notificação (E-mail, SMS, WhatsApp, Push, Alexa).
7. Conclusão
O projeto de automação da mini cidade, utilizando energia renovável e controle por microserviços, será baseado em uma arquitetura moderna e escalável, com microfrontends, aplicativos móveis e integração com serviços de notificação. A primeira fase incluirá a implementação do sistema de geração de energia solar e eólica e o desenvolvimento da aplicação web com microfrontends para monitoramento e controle dos dispositivos.

