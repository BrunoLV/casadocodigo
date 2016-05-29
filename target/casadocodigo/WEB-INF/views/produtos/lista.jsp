<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
            Casa do Código</title>

        <c:url value="/resources/css" var="urlCss"/>
        <link href="${urlCss}/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${urlCss}/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />

        <style>
            body {
                padding: 60px 0px;
            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do Código</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a></li>
                        <li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <security:authorize access="isAuthenticated()">
                            <security:authentication property="principal" var="usuario" />
                            <li><a href="#">Usuário: ${usuario.username}</a></li>
                            </security:authorize>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">

            <h1>Lista de Produtos</h1>
            <br />
            <div>${sucesso}</div>
            <div>${falha}</div>
            <br />

            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th>Título</th>
                    <th>Descrição</th>
                    <th>Páginas</th>
                </tr>

                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td>
                            <a href="${s:mvcUrl('PC#detalhar').arg(0, produto.id).build()}">${produto.titulo}</a>
                        </td>
                        <td>${produto.descricao}</td>
                        <td>${produto.paginas}</td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </body>
</html>