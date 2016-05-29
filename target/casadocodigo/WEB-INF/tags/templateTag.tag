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

<link rel="icon" href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?15063963123751285545" type="image/ico"/> 
  <link href="https://plus.googlecom/108540024862647200608" rel="publisher">
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/cssbase-min.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fonts.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fontello-ie7.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fontello-embedded.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fontello.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/book-collection.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/style.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/layout-colors.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/responsivo-style.css?5935512085070205644" rel="stylesheet" type="text/css"  media="all"  />

  <link rel="icon" href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?15063963123751285545" type="image/ico"/> 
  <link href="https://plus.googlecom/108540024862647200608" rel="publisher">

  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/cssbase-min.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fonts.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fontello-ie7.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fontello-embedded.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/fontello.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  
    <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/style.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/layout-colors.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link href="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/responsivo-style.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link rel="alternate" type="application/json+oembed" href="http://www.casadocodigo.com.br/products/livro-java8.oembed" />

  <link href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/guia-do-programador-style.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <link href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/products.css?15063963123751285545" rel="stylesheet" type="text/css"  media="all"  />
  <script type="text/javascript" src='http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js'></script>
  <link rel="canonical" href="http://www.casadocodigo.com.br/products/livro-java8" />

        <title>${titulo}</title>

    </head>
    <body class="${bodyClass}">

        <%@include file="/WEB-INF/views/template/cabecalho.jsp" %>

        <jsp:doBody />

        <%@include file="/WEB-INF/views/template/rodape.jsp" %>
        
        <jsp:invoke fragment="extraScripts" />

    </body>
</html>