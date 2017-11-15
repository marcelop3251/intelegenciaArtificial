<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Trabalho de Inteligencia Artificial</h1>


	<form action="cadastro" method="get"
		style="display: inline; margin: 10px;">
		<button type="submit"
			style="display: inline; background: #428bca; width: 300px; height: 50px; font-weight: bold; font-size: 20px; color: #fff;">Cadastrar</button>
	</form>

	<form action="exportacao" method="get"
		style="display: inline; margin: 10px;">
		<button type="submit"
			style="display: inline; background: #428bca; width: 300px; height: 50px; font-weight: bold; font-size: 20px; color: #fff;">Exportar</button>
	</form>
	<form action="processar" method="get"
		style="display: inline; margin: 10px;">
		<button type="submit"
			style="display: inline; background: #428bca; width: 300px; height: 50px; font-weight: bold; font-size: 20px; color: #fff;">Processar
			Dados</button>
	</form>

</body>
</html>