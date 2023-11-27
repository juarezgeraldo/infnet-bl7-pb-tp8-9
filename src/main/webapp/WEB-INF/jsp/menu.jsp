<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/app">Aplicativo Artesanato</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<c:if test="${not empty user}">
						<li>
							<a href="/acessorio/lista">
								<span class="glyphicon glyphicon-lock"></span>
								Acessório
							</a>
						</li>
						<li>
							<a href="/bolsa/lista">
								<span class="glyphicon glyphicon-lock"></span>
								Bolsa
							</a>
						</li>
						<li>
							<a href="/decoracao/lista">
								<span class="glyphicon glyphicon-lock"></span>
								Decoração
							</a>
						</li>
						<li>
							<a href="/artesanato/lista">
								<span class="glyphicon glyphicon-lock"></span>
								Artesanatos
							</a>
						</li>
						<li>
							<a href="/cliente/lista">
								<span class="glyphicon glyphicon-lock"></span>
								Cliente
							</a>
						</li>
						<li>
							<a href="/encomenda/lista">
								<span class="glyphicon glyphicon-lock"></span>
								Encomenda
							</a>
						</li>
						<li>
							<a href="/usuario/lista">
								<span class="glyphicon glyphicon-user"></span>
								Usuário
							</a>
						</li>
					</c:if>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${empty user}">
						<li>
							<form action="/usuario/cadastro/inicio" method="GET">


								<!-- <input type="submit" value="Submit" />
								<span class="glyphicon glyphicon-user"></span>
								Criar usuário -->

								<button type="submit" class="btn btn-link">
									<span class="glyphicon glyphicon-user"></span>
									Criar usuário
								</button>

								<!-- <a type="submit" href="/usuario/cadastro">
									<span class="glyphicon glyphicon-user"></span>
									Criar usuário
								</a> -->
							</form>
						</li>
						<li>
							<a href="/login">
								<span class="glyphicon glyphicon-log-in"></span>
								Entrar
							</a>
						</li>
					</c:if>
					<c:if test="${not empty user}">
						<li>
							<a href="/logout">
								<span class="glyphicon glyphicon-log-out">

								</span>
								Finalizar, ${user.nome}!!!
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</nav>