<%-- 
    Document   : templateTag
    Created on : 26/05/2016, 15:15:38
    Author     : bruno
--%>

<%@ tag description="tag de template das tags da aplicação" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="titulo" required="true"%>
<%@attribute name="bodyClass" required="false" %>
<%@attribute name="extraScripts" fragment="true" required="false" %>

<%-- any content can be specified here e.g.: --%>

<!DOCTYPE html>
<html>
    <head>
        <c:url value="/" var="contextPath" />
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
        <link rel="icon"
              href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979"
              type="image/ico" />
        <link href="https://plus.googlecom/108540024862647200608"
              rel="publisher"/>

        <link href="${contextPath}resources/css/cssbase-min.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
              rel='stylesheet'/>
        <link href="${contextPath}resources/css/fonts.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/fontello-ie7.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/fontello-embedded.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/fontello.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/style.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/layout-colors.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/responsive-style.css"
              rel="stylesheet" type="text/css" media="all" />
        <link href="${contextPath}resources/css/guia-do-programador-style.css" 
              rel="stylesheet" type="text/css"  media="all"  />
        <link href="${contextPath}resources/css/produtos.css" 
              rel="stylesheet" type="text/css"  media="all"  />
        <link rel="canonical" href="http://www.casadocodigo.com.br/" />	
        <link href="${contextPath}resources/css/book-collection.css"
              rel="stylesheet" type="text/css" media="all" />

        <title>${titulo}</title>

    </head>
    <body class="${bodyClass}">

        <%@include file="/WEB-INF/views/template/cabecalho.jsp" %>

        <jsp:doBody />

        <%@include file="/WEB-INF/views/template/rodape.jsp" %>
        
        <jsp:invoke fragment="extraScripts" />

    </body>
</html>