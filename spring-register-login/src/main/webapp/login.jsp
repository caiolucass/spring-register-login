<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-BR">

  <head>
      <meta charset="utf-8">
      <title>Pagina teste de Login</title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <!--Begin Body-->
  <body>
      <div class="container">
          <form method="post" action="${contextPath}/login" class="form-signin">
            <h2 class="form-heading">Log in</h2>

            <div class="form-group ${error != null ? 'has-error' :''}">
              <span>${message}</span>
              <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true">
              <input name="password" type="password" class="form-control" placeholder="Password">
              <span>${error}</span>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  
              <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
              <h4 class="text-center"><a href="${conxtetPath}/registration">Criar uma conta</a></h4>
            </div>
          </form>
      </div>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
  