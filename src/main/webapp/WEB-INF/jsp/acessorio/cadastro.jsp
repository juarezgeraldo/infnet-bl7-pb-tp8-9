<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h2>Cadastro de Acessórios</h2>
				<form action="/acessorio/incluir" method="POST">

					<div class="form-group">
						<label>Tipo:</label>
						<select class="form-control" name="tipo">
							<option selected="selected">Brinco</option>
							<option>Anel</option>
							<option>Colar</option>
							<option>Tiara</option>
							<option>Pulseira</option>
						</select>
					</div>

					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" required
							placeholder="Entre com o nome do artesanato" name="nome">
					</div>

					<div class="form-group">
						<div class="radio">
							<label>Fabricação própria?:</label>
							<label><input type="radio" name="proprio" checked="checked" value="true">Sim</label>
							<label><input type="radio" name="proprio" value="false">Não</label>
						</div>
					</div>

					<div class="form-group">
						<label>Qtde itens do conjunto:</label>
						<input value="1" type="number" min="1" class="form-control" required
							placeholder="Entre com a quantidade de itens" name="quantidade">
					</div>

					<div class="form-group">
						<label>Valor base:</label>
						<input  type="number" min="0.00" step="0.01" class="form-control" required
							value="0.00" name="valorBase">
					</div>

					<div class="form-group">
						<label>Valor Desconto:</label>
						<input type="number" min="0.00" step="0.01" value="0.00" class="form-control" required
							placeholder="Entre com valor máximo do desconto" name="desconto">
					</div>

					<br/>
					<div class="form-group">
						<label>Usuario do cadastro:</label>
						<span>${user.nome}</span>
					</div>

					<button type="submit" class="btn btn-default">Cadastrar</button>
				</form>
			</div>

		</body>

		</html>