<link rel="stylesheet" type="text/css" href="./style/css/bootstrap.min.css" >		
<form action="cliente" method="post">
	<label> 
		Valor: 
		<input type="text" name="valor" class="form-control" id="conta" placeholder="Valor a sacar"/>
	</label> 
	<input type="hidden" name="acao" value="SacarController" /> 
	<input type="submit" value="Sacar" class="btn btn-primary" id="Sacar"></input>
</form>