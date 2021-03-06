<html>
<head>
	<title>LaSiS - Servi�os do sistema HUMV-UFRB</title>
	<meta charset="utf-8">
</head>
<body>
    <h1>Servi�os do sistema HUMV-UFRB</h1>
    <br/>
    <h2>Usuario</h2>
    <ul>
    	<li>Obter todos: /api/usuario (GET)</li>
    	<li>Obter um usu�rio: /api/usuario/{email} (GET)</li>
    	<li>Buscar por e-mail ou nome: /api/usuario/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Obter todos os m�dicos ativos: /api/usuario/obterMedicosAtivos (GET)</li>
    	<li>Inserir: /api/usuario (POST)</li>
    	<li>Alterar: /api/usuario (PUT)</li>
    	<li>Excluir: /api/usuario/{email} (DELETE)</li>
    </ul>
    <h2>Dono</h2>
    <ul>
    	<li>Obter todos: /api/dono (GET)</li>
    	<li>Obter um dono: /api/dono/{id} (GET)</li>
    	<li>Buscar por CPF ou nome: /api/dono/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/dono (POST)</li>
    	<li>Alterar: /api/dono (PUT)</li>
    	<li>Excluir: /api/dono/{id} (DELETE)</li>
    </ul>
    <h2>Animal</h2>
    <ul>
    	<li>Obter todos: /api/animal (GET)</li>
    	<li>Obter um animal pequeno: /api/animal/{rghumv} (GET)</li>
    	<li>Buscar por RGHUMV ou nome: /api/animal/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/animal (POST)</li>
    	<li>Alterar: /api/animal (PUT)</li>
    	<li>Excluir: /api/animal/{rghumv} (DELETE)</li>
    </ul>
    <h2>Setor</h2>
    <ul>
    	<li>Obter todos: /api/setor (GET)</li>
    	<li>Obter um setor: /api/setor/{codigo} (GET)</li>
    	<li>Buscar por c�digo ou nome: /api/setor/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/setor (POST)</li>
    	<li>Inserir retornando o setor cadastrado: /api/setor/retornaCadastrado (POST)</li>
    	<li>Alterar: /api/setor (PUT)</li>
    	<li>Excluir: /api/setor/{codigo} (DELETE)</li>
    </ul>
    <h2>Procedimento</h2>
    <ul>
    	<li>Obter todos: /api/procedimento (GET)</li>
    	<li>Obter um procedimento: /api/procedimento/{codigo} (GET)</li>
    	<li>Buscar por c�digo ou nome: /api/procedimento/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/procedimento (POST)</li>
    	<li>Alterar: /api/procedimento (PUT)</li>
    	<li>Excluir: /api/procedimento/{codigo} (DELETE)</li>
    </ul>
    <h2>Atendimento</h2>
    <ul>
    	<li>Obter todos: /api/atendimento (GET)</li>
    	<li>Obter atendimentos do m�dico em uma determinada data, removendo cancelados: /api/atendimento/searchByDateAndMedicoSemCancelados?data=[<i>data_agendamento</i>]&amp;idEmailMedico=[<i>email_usuario</i>] (GET)</li>
    	<li>Obter todos os atendimentos do m�dico em uma determinada data: /api/atendimento/searchByDateAndMedico?data=[<i>data_agendamento</i>]&amp;idEmailMedico=[<i>email_usuario</i>] (GET)</li>
    	<li>Obter um atendimento: /api/atendimento/{id} (GET)</li>
    	<li>Inserir: /api/atendimento (POST)</li>
    	<li>Alterar: /api/atendimento (PUT)</li>
    	<li>Cancelar grupos de atendimentos: /api/atendimento/cancelarAtendimentos (PUT)</li>
    	<li>Excluir: /api/atendimento/{id} (DELETE)</li>
    </ul>
    <h2>Questin�rio socioecon�mico</h2>
    <ul>
    	<li>Obter todos: /api/questionarioSocioeconomico (GET)</li>
    	<li>Obter um questin�rio socioecon�mico: /api/questionarioSocioeconomico/{id} (GET)</li>
    	<li>Buscar por nome do dono: /api/questionarioSocioeconomico/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/questionarioSocioeconomico (POST)</li>
    	<li>Alterar: /api/questionarioSocioeconomico (PUT)</li>
    	<li>Excluir: /api/questionarioSocioeconomico/{id} (DELETE)</li>
    </ul>
    <h2>Atendimento social</h2>
    <ul>
    	<li>Obter todos: /api/atendimentoSocial (GET)</li>
    	<li>Obter um atendimento social: /api/atendimentoSocial/{id} (GET)</li>
    	<li>Buscar por CPF do dono, RGHUMV do animal ou nome do dono: /api/atendimentoSocial/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/atendimentoSocial (POST)</li>
    	<li>Alterar: /api/atendimentoSocial (PUT)</li>
    	<li>Excluir: /api/atendimentoSocial/{id} (DELETE)</li>
    </ul>
    <h2>Material</h2>
    <ul>
    	<li>Obter todos: /api/material (GET)</li>
    	<li>Obter um: /api/material/{id} (GET)</li>
    	<li>Inserir: /api/material (POST)</li>
    	<li>Alterar: /api/material (PUT)</li>
    	<li>Excluir: /api/material/{id} (DELETE)</li>
    </ul>
    <h2>Solicitacao e Liberacao de Material</h2>
    <ul>
    	<li>Obter todos: /api/solicitacaoMaterial (GET)</li>
    	<li>Obter um: /api/solicitacaoMaterial/{id} (GET)</li>
    	<li>Inserir: /api/solicitacaoMaterial (POST)</li>
    	<li>Alterar: /api/solicitacaoMaterial (PUT)</li>
    	<li>Excluir: /api/solicitacaoMaterial/{id} (DELETE)</li>
    </ul>
</body>
</html>
