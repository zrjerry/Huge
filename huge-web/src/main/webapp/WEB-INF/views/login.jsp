<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="zh">

<head>
  <meta charset="utf-8">
  <link rel="icon" href="/ico/favicon.ico">

  <title>Signin Template for Bootstrap</title>

  <!-- Bootstrap core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/css/login/login.css" rel="stylesheet">
</head>

<body class="text-center">
  <form class="form-signin" id="formlogin">
    <img class="mb-4" src="../image/logo.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only" >Email address</label>
    <input type="text" id="inputEmail" class="form-control" name="username" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" id="ck" value="remember-me" checked="checked"> Remember me
      </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" id="loginsubmit" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
  </form>


  <!-- 公共js -->
  <script src="/js/jquery-3.3.1.min.js"></script>
  <script src="/js/bootstrap.bundle.min.js"></script>
  <script src="/js/login/login.js"></script>
  <script src="/js/remember.js"></script>
  <script src="/js/jquery.cookie.js"></script>
</body>

</html>