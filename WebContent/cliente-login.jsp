<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/style/css/bootstrap.min.css" >
<head>
<link rel="stylesheet" type="text/css" href="./style/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente Login</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<a class="navbar-brand" href="index.html"><img src="./style/usjt.png" class="img-circle" alt="Responsive image"></a>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav"></ul>
		</div>
	</nav>
		
	<div class="container-fluid" style="margin-top: 80px; backgorund: #81DAF5;">
	</div>
	
	
	<div class="container">
		<div class="row">
			<div class="col-xs-4 col-xs-offset-4">
				<div class="highlight">
					<form action="cliente" method="post">
						<div class="form-group">
							<label for="loginTxt">Numero Conta:</label>
							<input type="text" name="numero" class="form-control" id="loginTxt" placeholder="Numero da conta">
							<br></br>
							<label for="loginTxt">Senha:</label>
							<input type="password" name="senha" class="form-control" id="senha" placeholder="Senha">
						</div>
						<div class="alert alert-danger" role="alert" style="display:none;" id="erroLogin"><span class="glyphicon glyphicon-remove"></span> Login ou Senha Inválidos!</div>

						<input type="submit" value="Logar" class="btn btn-primary" id="Logar"></input>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>