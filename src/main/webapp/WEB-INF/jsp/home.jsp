<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>

			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h3>Sistema de encomendas para artesanato</h3>
				<h4>AT da disciplina de Desenvolvimento Web com Java EE</h4>
				<br />
				<br />
				<br />
				<div class="form-group">
					<div class="row ajusteRow">
						<div class="col-md-5">
							<h4>Estatística de registros no sistema:</h4>
							<ul class="list-group">
								<c:forEach items="${totalizacao}" var="totalizacao">
									<li class="list-group-item">Quantidade de ${totalizacao.key}<span class="badge">${totalizacao.value}</span></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>

		</body>

		</html>