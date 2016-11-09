<link rel="stylesheet" type="text/css" href="./style/css/bootstrap.min.css" >
<form action="cliente" method="post">
	<label> 
		Para: 
		<input type="text" name="conta" class="form-control" id="conta" placeholder="Numero da conta"/>
	</label> 
	<label> 
		Valor: 
		<input type="text" name="valor" class="form-control" id="valor" placeholder="Valor da transferencia"/>
	</label> 
	<input type="hidden" name="acao" value="TransferenciaController" /> 
	<input type="submit" value="Transferir" class="btn btn-primary" id="Logar"></input>
</form>