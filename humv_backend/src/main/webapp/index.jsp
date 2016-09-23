<html>
<head>
	<title>LaSiS - Serviços do sistema HUMV-UFRB</title>
	<meta charset="utf-8">
</head>
<body>
    <h1>Serviços do sistema HUMV-UFRB</h1>
    <br/>
    <h2>Usuario</h2>
    <ul>
    	<li>Obter todos: /api/usuario (GET)</li>
    	<li>Obter um usuário: /api/usuario/{email} (GET)</li>
    	<li>Buscar por e-mail ou nome: /api/usuario/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Obter todos os médicos ativos: /api/usuario/obterMedicosAtivos (GET)</li>
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
    	<li>Buscar por código ou nome: /api/setor/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/setor (POST)</li>
    	<li>Inserir retornando o setor cadastrado: /api/setor/retornaCadastrado (POST)</li>
    	<li>Alterar: /api/setor (PUT)</li>
    	<li>Excluir: /api/setor/{codigo} (DELETE)</li>
    </ul>
    <h2>Procedimento</h2>
    <ul>
    	<li>Obter todos: /api/procedimento (GET)</li>
    	<li>Obter um procedimento: /api/procedimento/{codigo} (GET)</li>
    	<li>Buscar por código ou nome: /api/procedimento/search?palavrachave=[<i>palavra</i>] (GET)</li>
    	<li>Inserir: /api/procedimento (POST)</li>
    	<li>Alterar: /api/procedimento (PUT)</li>
    	<li>Excluir: /api/procedimento/{codigo} (DELETE)</li>
    </ul>
    <h2>Atendimento</h2>
    <ul>
    	<li>Obter todos: /api/atendimento (GET)</li>
    	<li>Obter atendimentos do médico em uma determinada data, removendo cancelados: /api/atendimento/searchByDateAndMedicoSemCancelados?data=[<i>data_agendamento</i>]&amp;idEmailMedico=[<i>email_usuario</i>] (GET)</li>
    	<li>Obter todos os atendimentos do médico em uma determinada data: /api/atendimento/searchByDateAndMedico?data=[<i>data_agendamento</i>]&amp;idEmailMedico=[<i>email_usuario</i>] (GET)</li>
    	<li>Obter um atendimento: /api/atendimento/{id} (GET)</li>
    	<li>Inserir: /api/atendimento (POST)</li>
    	<li>Alterar: /api/atendimento (PUT)</li>
    	<li>Excluir: /api/atendimento/{id} (DELETE)</li>
    </ul>
</body>
</html>
