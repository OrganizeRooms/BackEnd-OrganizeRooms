CREATE PROCEDURE `PROC_RECUPERA_EQUIPAMENTOS` (idUnidade INT, dataInicial DATETIME, dataFinal DATETIME)
BEGIN
select eq.equ_id, eq.equ_nome, eq.equ_descricao from equipamento eq
left join reserva_equipamento rs on rs.equ_id = eq.equ_id
left join agendamento ag on ag.age_id = rs.age_id
where eq.equ_ativa = 1 and eq.uni_id = idUnidade
and 

((
case
	when ag.age_hora_inicio > dataInicial then
	ag.age_hora_inicio >= dataInicial
	AND ag.age_hora_inicio >= dataFinal
else
	ag.age_hora_fim <= dataInicial
	AND ag.age_hora_fim < dataFinal
end) or (
	ag.age_data is null
));
END
