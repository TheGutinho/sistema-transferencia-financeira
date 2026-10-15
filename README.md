# Sistema de Agendamento de Transferências Financeiras

Aplicação Full Stack desenvolvida como teste técnico para avaliação de código, arquitetura, eficiência e padrões de desenvolvimento. O sistema permite o agendamento de transferências financeiras com cálculo automático de taxas baseadas no número de dias até à data da transferência, além da visualização do extrato completo[cite: 6].

---

## 🛠️ Tecnologias e Versões Utilizadas

* **Backend:** Java 11, Spring Boot (2.7.18), Spring Data JPA, Bean Validation.
* **Base de Dados:** H2 Database (In-memory)[cite: 6].
* **Frontend:** Angular, TypeScript, HTML5, CSS3.
* **Ferramentas de Build:** Maven (Maven Wrapper) e npm.

---

## 📐 Decisões Arquiteturais

1. **Separação de Camadas (Backend):** 
   O projeto adota o padrão em camadas (`Controller`, `Service`, `Repository` e `Model`), garantindo que a regra de negócio central (o cálculo das taxas e a validação do intervalo de 0 a 50 dias) esteja totalmente isolada dos adaptadores web.
2. **Validação de Regras de Negócio e Taxas:** 
   O cálculo da taxa obedece rigorosamente à tabela estipulada (variando entre dias de antecedência e percentuais/valores fixos)[cite: 6]. Caso o utilizador selecione um período sem taxa aplicável (acima de 50 dias ou datas retroativas), a API intercepta a requisição, lança uma exceção de validação e retorna um alerta HTTP 400, impedindo o agendamento indevido[cite: 6].
3. **Persistência Volátil:** 
   Utilização de uma base de dados H2 em memória para garantir portabilidade imediata e execução sem necessidade de configuração prévia de infraestrutura externa[cite: 6].

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* **JDK 11** instalado e configurado na variável de sistema `JAVA_HOME`.
* **Node.js e npm** instalados.

---

### 1. Executando o Backend (Spring Boot)
1. Abre um terminal e acede à pasta do backend:
   ```bash
   cd transferencia-api
