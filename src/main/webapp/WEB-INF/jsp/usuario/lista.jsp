<%@page import="br.edu.infnet.appArtesanato.model.domain.Usuario" %>
	<%@page import="java.util.List" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<!DOCTYPE html>
				<html>

				<c:import url="/WEB-INF/jsp/header.jsp"></c:import>


				<body>

					<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

					<div class="container">
						<h3>Usuários</h3>

						<c:if test="${not empty user}">
							<c:if test="${user.admin}">
								<form action="/usuario/cadastro" method="GET">
									<button type="submit" class="btn btn-link">Incluir</button>
								</form>
							</c:if>
						</c:if>
						<hr>

						<c:if test="${not empty lista}">
							<c:if test="${not empty msg}">
								<c:if test="${idMsg == 'sucesso'}">
									<div class="alert alert-success">
										<strong>Sucesso!</strong> ${msg}
									</div>
								</c:if>
								<c:if test="${idMsg != 'sucesso'}">
									<div class="alert alert-danger">
										<strong>ERRO!</strong> ${msg}
									</div>
								</c:if>
							</c:if>

							<h4>Quantidade de usuários cadastrados: ${lista.size()}!!!</h4>

							<hr>
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="text-align: center;">Id</th>
										<th style="text-align: center;">Nome</th>
										<th style="text-align: center;">E-mail</th>
										<th style="text-align: center;">Clientes</th>
										<th style="text-align: center;">Artesanatos</th>
										<th style="text-align: center;">Encomendas</th>
										<th style="text-align: center;">Administrador?</th>
										<th style="text-align: center;">
											<!-- <th style="text-align: center;"></th> -->
											<c:if test="${user.admin}">
												<span> Ação </span>
											</c:if>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="a" items="${lista}">
										<tr>
											<td style="text-align: center;">${a.id}</td>
											<td style="text-align: center;">${a.nome}</td>
											<td style="text-align: center;">${a.email}</td>
											<td style="text-align: center;">${a.qtClientes}</td>
											<td style="text-align: center;">${a.qtArtesanatos}</td>
											<td style="text-align: center;">${a.qtEncomendas}</td>
											<td style="text-align: center;">
												<c:choose>
													<c:when test="${a.admin}">
														<span>Sim</span>
													</c:when>
													<c:when test="${!a.admin}">
														<span>Não</span>
													</c:when>
												</c:choose>
											</td>
											<!-- <td style="text-align: center;"><a href="/usuario/${a.id}/editar">Editar</a></td> -->
											<td style="text-align: center;">
												<c:if test="${user.admin}">
													<c:choose>
														<c:when test="${user.id != a.id}">
															<a href="/usuario/${a.id}/excluir">Excluir</a>
														</c:when>
													</c:choose>
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>

						<c:if test="${empty lista}">
							<h4>Não há usuários cadastrados!!!</h4>
						</c:if>
					</div>
				</body>

				</html>