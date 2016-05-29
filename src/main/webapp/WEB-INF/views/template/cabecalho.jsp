<%-- 
    Document   : cabecalho
    Created on : 26/05/2016, 15:19:14
    Author     : bruno
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<header id="layout-header">
	<div class="clearfix container">
		<a href="${s:mvcUrl('HC#index').build()}" id="logo"> </a>
		<div id="header-content">
			<nav id="main-nav">

				<ul class="clearfix">
					<li><a href="${s:mvcUrl('CCC#listar').build()}" rel="nofollow">
							<s:message code="menu.cart"
								arguments="${carrinhoCompras.quantidade}"></s:message>
					</a></li>

					<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">
							<s:message code="menu.about" />
					</a></li>
					
					<li><a href="?locale=pt_BR" rel="nofollow">
							Português
					</a></li>
					
					<li><a href="?locale=en_US" rel="nofollow">
							Inglês
					</a></li>

					<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas
							Frequentes</a></li>
				</ul>
			</nav>
		</div>
	</div>
</header>

<nav class="categories-nav">
	<ul class="container">
		<li class="category"><a href="http://www.casadocodigo.com.br">Home</a></li>
		<li class="category"><a href="/collections/livros-de-agile">
				Agile </a></li>
		<li class="category"><a href="/collections/livros-de-front-end">
				Front End </a></li>
		<li class="category"><a href="/collections/livros-de-games">
				Games </a></li>
		<li class="category"><a href="/collections/livros-de-java">
				Java </a></li>
		<li class="category"><a href="/collections/livros-de-mobile">
				Mobile </a></li>
		<li class="category"><a
			href="/collections/livros-desenvolvimento-web"> Web </a></li>
		<li class="category"><a href="/collections/outros"> Outros </a></li>
	</ul>
</nav>
