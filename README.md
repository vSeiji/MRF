<!-- Nome do projeto -->
# MRF <!-- Listagem dos endpoints -->
## Endpoints 
- [Cadastro de Refeicao](#cadastro-de-refeicao)
- [Ver alimentacao](#ver-alimentacao)
- Escolha data
- Listar refeicoes
- Apagar refeicao
- Editar refeicao 

---

### Cadastro de refeicao 
<!-- Endereço do recurso -->
`POST` mrf/api/v1/refeicao

<!-- Colocar a versão é importante para compatibilidade  --> 
**Exemplo de Entrada** 
```js
{
    "dia": '2023-01-01',
    "horario": '08:30',
    "tipoRefeicao": "Cafe da manha",
    "refeicao": 'pão',
    "bebida": "suco de laranja,
    "calorias": '100 kcal'
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|dia|sim|data| a data da refeicao
|horario|sim|date| horário da refeicao
|categoria_id|sim|option| O id da categoria da refeicao, entre café da manhã, almoco, café da tarde e jantar
|refeicao|sim|text| refeicao ingerida
|calorias|sim|decimal| calorias da refeicao

**Códigos da Resposta**

|código|descrição
|-|-
201 | a refeicao foi cadastrada com sucesso
400 | os dados enviados são inválidos

---


### Ver Alimentacao

`GET` mrf/api/v1/alimentacao

**Exemplo de Resposta** 
```js
{
    datas : {
       data: data,
       data: data2,
       data: data3,
       data: data4
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | as datas foram retornados
404 | não existe nenhuma data cadastrada


---

### Minhas Refeicoes

`GET` mrf/api/v1/alimentacao/refeicoes/{id}

**Exemplo de Resposta** 

```js
{
    refeicoes: {
        dia: "13/02/2023 - "08:30" ,
        categoria: "Café da Manhã,
        refeicao: "Pão com Queijo e Presunto",
        bebida: "Suco de Laranja",
        calorias: "280kcal"
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados da refeicao foram retornados
404 | não existe nenhuma refeicao cadastrada

teste