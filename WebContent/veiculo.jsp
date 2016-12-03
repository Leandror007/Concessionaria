<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.text.NumberFormat" %>
<%@page import="java.util.Vector" %>
<%@page import="controle.Carro" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<style type="text/css">
	table{ width: 40%;}

	
	tr{ border: 1px solid black;}

</style>


<body>
<table style="border: #000 2px solid;" align="center" cellspacing="0" border="1">
<a href="index.jsp">Voltar</a>

	<tr style="background: #555555; color: white; padding: 0 margin: 0 auto">
		
		<th align="center"> <a>Imagem</a> </th>	
		<th align="center"> <a>Descricao</a> </th>	
		<th align="center"> <a>Valor</a> </th>	
		<th align="center"> <a>Excluir</a> </th>
	</tr>
	
	<% 
		Vector veiculo = (Vector) session.getAttribute("veiculo");
		double total = 0;
		for(int cont = 0; cont < veiculo.size(); cont++){
			Carro p = (Carro) veiculo.get(cont);
			total += p.getValor();
	%>
	<tr>
	<td align="center"> <a> <img alt="" src="<%=p.getLink()%>" width="80" heigth="80"> </a> </td>
	<td align="center"> <a> <%=p.getDescricao()%></a> </td>
	<td align="center"> <a> <%out.println(NumberFormat.getCurrencyInstance().format(p.getValor())); %> </a> </td>
	
	<td align="center"> <a> <input type="button" onclick="window.open('excluir?id=<%= cont%>', '_self');" value="Excluir"/>  </a> </td>
	</tr>
<%
		}
%>		
	<tr>

	<td colspan="4" bgcolor="#555555"> . </td>

	</tr>
	<tr>

	<td colspan="3" bgcolor="#555555" style="color: white;"> <a> TOTAL GERAL </a> </td>
	
	<td bgcolor="#555555" style="color: white;"> <strong><a> <%out.println(NumberFormat.getCurrencyInstance().format(total));%> </a> </strong></td>
	
	</tr>
	</table>	

</body>
</html>