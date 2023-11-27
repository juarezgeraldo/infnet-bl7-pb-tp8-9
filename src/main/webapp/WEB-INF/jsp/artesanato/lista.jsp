<%@page import="br.edu.infnet.appArtesanato.model.domain.Artesanato" %>
	<%@page import="java.util.List" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

				<!DOCTYPE html>
				<html>

				<c:import url="/WEB-INF/jsp/header.jsp"></c:import>


				<body>

					<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

					<div class="container">
						<h3>Artesanatos</h3>

						<c:if test="${not empty lista}">
							<c:if test="${not empty msg}">
								<c:if test="${not empty idMsg}">
									<c:if test="${idMsg == 'sucesso'}">
										<div class="alert alert-success">
											<strong>Sucesso!</strong> ${msg}
										</div>
									</c:if>
									<c:if test="${idMsg == 'erro'}">
										<div class="alert alert-danger">
											<strong>ERRO!</strong> ${msg}
										</div>
									</c:if>
								</c:if>
								<c:if test="${empty idMsg}">
									<div class="alert alert-success">
										<strong>Sucesso!</strong> ${msg}
									</div>
								</c:if>
							</c:if>

							<h4>Quantidade de artesanatos cadastrados: ${lista.size()}!!!</h4>

							<hr>

							<table class="table table-striped">
								<thead>
									<tr>
										<th style="text-align: center;">Id</th>
										<th style="text-align: center;">Nome</th>
										<th style="text-align: center;">Fabricação própria</th>
										<th style="text-align: center;">Valor base</th>
										<th style="text-align: center;">Usuário do cadastro</th>
										<th style="text-align: center;">Ação</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="a" items="${lista}">
										<tr>
											<td style="text-align: center;">${a.id}</td>
											<td style="text-align: center;">${a.nome}</td>
											<td  style="text-align: center;">
												<c:choose>
													<c:when test="${a.proprio}">
														<span>Sim</span>
													</c:when>
													<c:when test="${!a.proprio}">
														<span>Não</span>
													</c:when>
												</c:choose>
											</td>
											<td  style="text-align: center;">${a.valorBase}</td>
											<td  style="text-align: center;">${a.usuario.nome}</td>
											<td  style="text-align: center;"><a href="/artesanato/${a.id}/excluir">Excluir</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>

						<c:if test="${empty lista}">
							<h4>Não há artesanatos cadastrados!!!</h4>
						</c:if>
					</div>
				</body>

				</html>