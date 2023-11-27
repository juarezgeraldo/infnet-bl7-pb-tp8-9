<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h2>Cadastro de Bolsas</h2>
				<form action="/bolsa/incluir" method="POST">

					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" required
							placeholder="Entre com o nome do artesanato" name="nome">
					</div>

					<div class="form-group">
						<label>Material:</label>
						<select class="form-control" name="material">
							<option selected="selected">Couro</option>
							<option>Linha</option>
							<option>Tecido</option>
							<option>Malha</option>
							<option>Outros</option>
						</select>
					</div>

					<div class="form-group">
						<div class="radio">
							<label>Fabricação própria?:</label>
							<label><input type="radio" name="proprio" checked="checked" value="true">Sim</label>
							<label><input type="radio" name="proprio" value="false">Não</label>
						</div>
					</div>

					<div class="form-group">
						<label>Cor predominante:</label>
						<input type="text" class="form-control" required
							placeholder="Entre com a cor predominante" name="cor">
					</div>

					<div class="form-group">
						<label>Grau de dificuldade:</label>
						<input value="0" min="0" step="1" max="4" type="number" class="form-control" required
							placeholder="Entre com o grau de dificuldade" name="dificuldade">
					</div>

					<div class="form-group">
						<div class="radio">
							<label>Com fecho?:</label>
							<label><input type="radio" name="comFecho" checked="checked" value="true">Sim</label>
							<label><input type="radio" name="comFecho" value="false">Não</label>
						</div>
					</div>

					<div class="form-group">
						<label>Valor base:</label>
						<input  type="number" min="0.00" step="0.01" class="form-control" required
							value="0.00" name="valorBase">
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