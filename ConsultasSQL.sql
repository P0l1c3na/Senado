select descricao,quantidadecontratada, contratada from itens inner join contratos on itens.numerocontrato=contratos.numerocontratos where numerocontrato = 'CT-CT/20140041';

========== Despesa.findByValorReembolsadoTotal ==========
SELECT SUM(d.valor_reembolsado) FROM Despesa d WHERE d.senador = :senador