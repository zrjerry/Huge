<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- TODO -->
  <link rel="icon" href="/ico//favicon.ico">

  <title>Index</title>

  <!-- Bootstrap core CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">

  <!-- 公共样式 -->
  <link href="../css/navbar.css" rel="stylesheet">
  <link href="../css/main.css" rel="stylesheet">
</head>

<body>
  <!-- 导航栏 -->
  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu" aria-labelledby="dropdown01">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
      </ul>
      <div>
    	    <span id="login">您好！欢迎您的到来！
	        <a class="btn btn-outline-success my-2 my-sm-0 mr-2" href="/user/login" role="button">登录</a>
	        <a class="btn btn-outline-warning my-2 my-sm-0" href="/user/register" role="button">注册</a>
    	</div>
    </div>
  </nav>
  <!-- /导航栏 -->

  <main role="main" class="container-fluid">

    <div class="row">
      <div class="col-md-4">
        <form class="container">
        <div class="row">
        	<div class="col-sm-11">
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">出发</span>
            </div>
            <input  id="start" type="text" class="form-control" placeholder="输入城市名/车站名" aria-label="Username" aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">到达</span>
            </div>
            <input id="end" type="text" class="form-control" placeholder="输入城市名/车站名" aria-label="Username" aria-describedby="basic-addon1">
          </div>
        	</div>
        	<div class="col-sm-1">
        	<button id="exchange" type="button" class="btn btn-primary" style="margin-top: 25px">换</button>
        	</div>
        	
        	
        </div>
          
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">日期</span>
            </div>
            <input id="data" type="date" class="form-control" placeholder="输入城市名/车站名" aria-label="Username" aria-describedby="basic-addon1">
          </div>
          <button type="submit" class="btn btn-outline-primary" id="pri">Primary</button>
        </form>
      </div>
      
      <!-- 轮播图 -->
      <div class="col-md-8">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src="../image/index/lunbo1.png" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="../image/index/lunbo2.png" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="../image/index/lunbo3.png" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
      <!-- /轮播图 -->
    </div>
    <div class="starter-template">
      <h1>Bootstrap starter template</h1>
      <p class="lead">Use this document as a way to quickly start any new project.
        <br> All you get is this text and a mostly barebones HTML document.</p>
    </div>
  </main>
  <!-- /.container -->
  
  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- 公共js -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.bundle.min.js"></script>
     <script src="/js/static/index.js"></script>
     <script src="/js/jquery.cookie.js"></script>
    <script src="/js/huge.js"></script>
    <script src="/js/index/exchange.js"></script>
  </body>

</html>