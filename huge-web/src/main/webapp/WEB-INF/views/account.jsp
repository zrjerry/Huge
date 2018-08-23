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
  <link rel="icon" href="/ico/favicon.ico">

  <title>Index</title>

  <!-- Bootstrap core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <!-- 公共样式 -->
  <link href="/css/navbar.css" rel="stylesheet">
  <link href="/css/main.css" rel="stylesheet">
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
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
  <!-- /导航栏 -->



  <main role="main" class="container">
    <div class="row">
      <div class="col-3">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home"
            aria-selected="true">个人信息</a>
          <a class="nav-link" id="v-pills-order-tab" data-toggle="pill" href="#v-pills-order" role="tab" aria-controls="v-pills-profile"
            aria-selected="false">订单查询</a>
          <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages"
            aria-selected="false">账户设置</a>
          <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings"
            aria-selected="false">Settings</a>
        </div>
      </div>
      <div class="col-9">
        <div class="tab-content" id="v-pills-tabContent">
          <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">个人信息
           <table class="table table-striped">
              <tbody>
                <tr>
                  <td>姓名:</td>
                  <td><span id="account_userRealname"></span></td>
                </tr>
                 <tr>
                  <td>用户名:</td>
                  <td><span id="account_userName"></span></td>
                </tr>
                <tr>
                  <td>姓别:</td>
                  <td><span id="account_gender"></span></td>   
                </tr>
                <tr>
                  <td>身份证号:</td>
                  <td><span id="account_identityId"></span></td>   
                </tr>
              </tbody>
            </table>
          
          </div>
          <!-- 订单页面 -->
          <div class="tab-pane fade" id="v-pills-order" role="tabpanel" aria-labelledby="v-pills-order-tab">
            <div class="card mb-3">
              <h5 class="card-header">订单号:45215322545</h5>
              <div class="card-body">
                <h5 class="card-title"></h5>
                <p class="card-text">上海 - 杭州</p>
                <p class="card-text">8-3    当日</p>
                <p class="card-text">06:29   08:59</p>
                <a href="#" class="btn btn-primary disabled">退票</a>
              </div>
            </div>
          </div>
          <!-- /订单页面 -->
          <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">...</div>
          <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">...</div>
        </div>
      </div>
    </div>

  </main>


  <!-- 公共js -->
  <script src="/js/jquery-3.3.1.min.js"></script>
  <script src="/js/bootstrap.bundle.min.js"></script>
  <script src="/js/account/account.js"></script>
  <script src="/js/jquery.cookie.js"></script>
  
</body>

</html>