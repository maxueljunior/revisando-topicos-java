SELECT *
FROM tabela_de_clientes;

SELECT CPF as IDENTIFICADOR, NOME as CLIENTE FROM tabela_de_clientes;

SELECT *
FROM tabela_de_clientes
WHERE nome LIKE('%Mattos');

SELECT DISTINCT BAIRRO
FROM tabela_de_clientes
WHERE CIDADE = 'Rio de Janeiro'
LIMIT 2;

SELECT *
FROM notas_fiscais
WHERE DATA_VENDA = '2017-01-01'
LIMIT 10;

SELECT *
FROM itens_notas_fiscais
WHERE CODIGO_DO_PRODUTO = '1101035';

SELECT SUM(QUANTIDADE) as 'TOTAL DE VENDAS'
FROM itens_notas_fiscais
WHERE CODIGO_DO_PRODUTO = '1101035';

SELECT CODIGO_DO_PRODUTO, SUM(QUANTIDADE) as 'SOMA DE QNT'
FROM itens_notas_fiscais
GROUP BY CODIGO_DO_PRODUTO;

SELECT CPF, COUNT(*)
FROM notas_fiscais
WHERE YEAR(DATA_VENDA) = 2016
GROUP BY CPF
HAVING COUNT(*) > 2000;

SELECT NOME, DATA_DE_NASCIMENTO,
CASE
	WHEN YEAR(DATA_DE_NASCIMENTO) <= 1990 THEN 'VELHO'
    WHEN YEAR(DATA_DE_NASCIMENTO) > 1990 AND YEAR(DATA_DE_NASCIMENTO) <= 1995 THEN 'JOVEM'
    WHEN YEAR(DATA_DE_NASCIMENTO) > 1995 THEN 'CRIANÇA'
    ELSE 'NÃO TEM'
END AS 'STATUS'
FROM tabela_de_clientes
ORDER BY NOME desc;

SELECT * FROM itens_notas_fiscais;
SELECT * FROM notas_fiscais;

SELECT YEAR(A.DATA_VENDA), SUM(B.QUANTIDADE * B.PRECO) AS FATURAMENTO
FROM notas_fiscais A
INNER JOIN itens_notas_fiscais B
ON A.NUMERO = B.NUMERO
GROUP BY YEAR(A.DATA_VENDA);

SELECT YEAR(DATA_VENDA), SUM(QUANTIDADE * PRECO) AS FATURAMENTO
FROM notas_fiscais NF INNER JOIN itens_notas_fiscais INF 
ON NF.NUMERO = INF.NUMERO
GROUP BY YEAR(DATA_VENDA);

SELECT X.CPF, X.CONTADOR FROM
(SELECT CPF, COUNT(*) AS CONTADOR FROM notas_fiscais
WHERE YEAR(DATA_VENDA) = 2016
GROUP BY CPF) X WHERE X.CONTADOR > 2000;

SELECT * FROM itens_notas_fiscais;
SELECT * FROM tabela_de_produtos;

SELECT A.CODIGO_DO_PRODUTO, A.QUANTIDADE_VENDIDA FROM
(SELECT CODIGO_DO_PRODUTO, SUM(QUANTIDADE) AS QUANTIDADE_VENDIDA
 FROM itens_notas_fiscais
 GROUP BY CODIGO_DO_PRODUTO) A WHERE A.QUANTIDADE_VENDIDA < 390000;
 
 SELECT B.CODIGO_DO_PRODUTO, B.QUANTIDADE_VENDIDA, B.TOTAL_VENDAS FROM
 (SELECT CODIGO_DO_PRODUTO, SUM(QUANTIDADE) AS QUANTIDADE_VENDIDA, SUM(QUANTIDADE * PRECO) AS TOTAL_VENDAS
 FROM itens_notas_fiscais
 GROUP BY CODIGO_DO_PRODUTO) B WHERE B.TOTAL_VENDAS < 3300000;

SELECT DISTINCT * FROM tabela_de_produtos;

SELECT A.CODIGO_DO_PRODUTO, A.NOME_DO_PRODUTO, A.QUANTIDADE_VENDIDA,
CASE
	WHEN A.QUANTIDADE_VENDIDA > 390000 THEN 'MUITO VENDIDO'
    ELSE 'POUCO VENDIDO'
END AS 'STATUS'
FROM (SELECT C.CODIGO_DO_PRODUTO, B.NOME_DO_PRODUTO AS NOME_DO_PRODUTO, SUM(QUANTIDADE) AS QUANTIDADE_VENDIDA FROM itens_notas_fiscais C
INNER JOIN tabela_de_produtos B
WHERE C.CODIGO_DO_PRODUTO = B.CODIGO_DO_PRODUTO
GROUP BY C.CODIGO_DO_PRODUTO) A;