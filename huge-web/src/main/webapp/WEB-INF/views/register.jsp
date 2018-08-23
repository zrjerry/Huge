<!doctype html>
<html lang="zh">

<head>
  <meta charset="utf-8">
  <link rel="icon" href="../../../../favicon.ico">

  <title>Signin Template for Bootstrap</title>

  <!-- Bootstrap core CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/register/register.css" rel="stylesheet">
  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="../js/register/register.js"></script>
</head>

<body class="text-center">
  <form class="form-signin" id="idea">
    <img class="mb-4" src="../image/logo.png" alt="" width="90" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputname" class="sr-only">usename</label>
    <input type="text" name="usename" id="inputname" class="form-control" placeholder="usename" required autofocus>
     <span></span>
     <label for="inputname" class="sr-only">realusename</label>
    <input type="text" name="realusename" id="realusename" class="form-control" placeholder="realusename">
     <span></span>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="text" id="inputEmail" name="email" class="form-control" placeholder="Email address">
    <span></span>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
     <span></span>
     <label for="inputPassword2" class="sr-only">Password2</label>
    <input type="password" id="inputPassword2" name="password2" class="form-control" placeholder="PasswordRe" required>
     <span></span>
    <label for="inputidentity" class="sr-only">identity</label>
    <input type="text" id="inputidentity" name="indetity" class="form-control" placeholder="identity" required>
     <span></span>
    <div class="checkbox mb-3">
    <label>
    <span>gender:</span>&nbsp&nbsp&nbsp
    </label>
      <label id="gender">
        <input type="radio" name="gender" value="man"> man
      </label>
      <label>
        <input type="radio" name="gender" value="women"> women
      </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="register">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
  </form>
</body>


<!-- 公共js -->
<script src="../js/jquery-3.3.1.min.js" type="text/javascript" charset="uft-8"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="/js/static/register.js"></script>
</html>