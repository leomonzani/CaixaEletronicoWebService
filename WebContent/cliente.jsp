<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./style/css/bootstrap.min.css" >
<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
<title>Caixa Eletronico Web</title>
</head>
<body>	

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<a class="navbar-brand" href="index.html"><img src="./style/usjt.png" class="img-circle" alt="Responsive image"></a>
			<div id="navbar" class="collapse navbar-collapse">
			  <ul class="nav navbar-nav">   
				<li class="active"><a href="cliente.jsp">Inicio</a></li>
           		</ul>
           		<ul class="nav navbar-nav navbar-right">
       				<li><a href="sacar.jsp">Sacar</a></li>
					<li><a href="movimentacoes.jsp">Movimentações</a></li>
					<li><a href="transferencia.jsp">Transferencia</a></li>
					<li><a href="#"></a></li>
     			 </ul>
			</div>
		</nav>
		
		
	<div class="container-fluid" style="margin-top: 60px; backgorund: #81DAF5;">		
	
	<div class="container-fluid" style="margin-top: 60px; backgorund: #81DAF5;">	  
	<fieldset>
		<legend>Dados da Conta</legend>
		Numero da Conta:            ${user.conta.numero}<br>
		Nome:                       ${user.conta.titular}<br>
		Saldo:                   R$ ${user.conta.saldo}<br>
	</fieldset>
	</div>
	
	<div class="container-fluid" style="margin-top: 60px; backgorund: #81DAF5;">	
	<fieldset>
		<legend>Sacar</legend>
		<jsp:include page="sacar.jsp" />
	</fieldset>
	</div>
	
	<div class="container-fluid" style="margin-top: 60px; backgorund: #81DAF5;">	
	<fieldset>
		<legend>Transferencia</legend>
		<jsp:include page="transferencia.jsp" />
	</fieldset>
	</div>
	
	<div class="container-fluid" style="margin-top: 60px; backgorund: #81DAF5;">	
	<fieldset>
		<legend>Movimentacoes (${user.movimentacoes.size()})</legend>
		<jsp:include page="movimentacoes.jsp" />
	</fieldset>
	</div>
	
	<script src="assets/jquery/jquery-1.11.3.min.js"></script>
		
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>	
	
		<div class="container-fluid" style="margin-top: 60px; backgorund: #81DAF5;">
		</div>
	</div>
	
	<footer>
        <div class="navbar navbar-inverse navbar-fixed-bottom">
            <div class="container">
                <div class="navbar-collapse collapse" id="footer-body">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Sobre</a></li>
                        <li>
				<form action="cliente" method="post">
					<input type="hidden" name="acao" value="LogoutController" />
								<input type="submit" value="Logout" />
							</form>
						</li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#">Privacy Policy</a></li>
                    </ul>
                </div>
            </div>
        </div>
</footer>
	

	
</body>
</html>