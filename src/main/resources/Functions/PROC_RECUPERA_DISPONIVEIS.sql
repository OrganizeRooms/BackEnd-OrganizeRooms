CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_RECUPERA_DISPONIVEIS`(idUnidade INT, lotacao INT, dataInicial DATETIME, dataFinal DATETIME, dataAgendamento DATE)
BEGIN
	 SELECT SALA_ID, SALA_NOME, SALA_LOTACAO FROM  sala s
	LEFT join agendamento a  ON age_sala = sala_id
	WHERE (s.uni_id = idUnidade
	AND s.sala_lotacao >= lotacao
	AND (a.age_status = 'CANCELADO'
	OR a.age_status IS NULL)
	AND sala_ativa = 1)
    or (a.age_data is not null and a.age_data <> dataAgendamento)
    GROUP BY SALA_ID, SALA_NOME, SALA_LOTACAO
	UNION 
	SELECT SALA_ID, SALA_NOME, SALA_LOTACAO FROM  sala s WHERE SALA_ID IN (
	SELECT 
	case 
	when 
		case
			when min(a.age_hora_inicio) > dataInicial then
		min(a.age_hora_inicio) >= dataInicial
	  AND min(a.age_hora_inicio) >= dataFinal
  		else
  		max(a.age_hora_fim) <= dataInicial
	  AND max(a.age_hora_fim) < dataFinal
  		end
	  then s.sala_id ELSE NULL END  from sala s
	inner join agendamento a  ON age_sala = sala_id
	WHERE s.uni_id = idUnidade
	AND s.sala_lotacao >= lotacao 
	AND a.age_data = dataAgendamento 
	GROUP BY sala_id);

 END