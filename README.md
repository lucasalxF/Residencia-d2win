# Residencia-d2win

# 📊 Di2win Monitoring

Aplicação desenvolvida para monitoramento de APIs utilizadas pela empresa Di2win, que atua com soluções em inteligência artificial. Este sistema detecta, organiza e exporta dados relacionados a falhas e instabilidades nas APIs, permitindo o acompanhamento em tempo real por meio de um dashboard visual e intuitivo.

---

## 🧠 Resumo do Sistema

A **Di2win Monitoring** é uma aplicação web que:

- Exibe erros e instabilidades detectados nas chamadas de API
- Associa cada erro a um **cliente** e ao **modelo de IA** utilizado
- Permite exportação dos erros em formato de **planilha Excel (.xlsx)**
- Apresenta **gráficos analíticos** e um **calendário** de visualização
- Inclui páginas de **login** e **cadastro**, com navegação roteada

---

## 🎯 Problema que estamos resolvendo

A Di2win atende diversos clientes utilizando APIs com modelos de IA. Falhas ou quedas podem gerar grandes prejuízos. O sistema vem para **automatizar o monitoramento**, **organizar os dados** e **facilitar a exportação** para análise e tomada de decisão rápida.

---

## 🖼️ Protótipo no Figma

> Link para o design no Figma:  
📌 [https://www.figma.com/]([https://www.figma.com/file/SEU-LINK-AQUI](https://www.figma.com/design/pnfdrYl38mUspXzKkilxbe/Di2win?m=auto&t=LuVzgEhLhW6S34k9-1))

---
## Documentação

> Link para a documentação no Google Docs
📌 [https://docs.google.com/](https://docs.google.com/document/d/1-g3fLyP4lZajDj6inDFln7cNRdcmuU1FSJoCIFmXRiM/edit?usp=sharing)
---

## ⚙️ Tecnologias Utilizadas

### 🧩 **Front-end** – Desenvolvido com:
- [React.js](https://reactjs.org/) + [Vite](https://vitejs.dev/)
- JavaScript
- CSS Modules
- [Recharts](https://recharts.org/) (gráficos)
- [SheetJS (xlsx)](https://sheetjs.com/) (exportação Excel)

### 💾 **Back-end** – Simulado com:
- [Postman](https://www.postman.com/) (testes e mock de API)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (IDE de desenvolvimento)
- [PostgreSQL](https://www.postgresql.org/) (banco de dados – não implementado no front ainda)

---

## 🧪 Como rodar localmente

### 📦 Pré-requisitos

- Node.js LTS instalado
- Git

### 🚀 Passos para executar o front-end

```bash
# Clone o repositório
git clone https://github.com/seuusuario/di2win-monitoring-frontend.git

# Acesse a pasta do projeto
cd di2win-monitoring-frontend

# Instale as dependências
npm install

# Rode o projeto
npm run dev
