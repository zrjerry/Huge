<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!-- 引入样式文件和动态控制 -->

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/manage/manage.js"></script>
<script src="../js/jquery.cookie.js"></script>

<link href="../css/bootstrap.min.3.3.7.css" rel="stylesheet">
<title>后台管理界面</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">后台管理系统</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">欢迎,admin</a></li>
				<li><a href="#">退出</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#"></a></li>
            <li><a href="#" id="user_label">用户管理</a></li>
            <li><a href="#" id="order_label">订单管理</a></li>
            <li><a href="#" id="ticket_label">余票管理</a></li>
          </ul>  
        </div>
        <div class="col-sm-6 col-md-9 sidebar">
          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped ">
              <thead>
                <tr>
                   <th><a id="table_name">管理</a></th>   
                   <th><input id="searchbox" class="form-control" placeholder="用户搜索" type="text"><th>    
                    <th><a class="text-error" href="#" id="searchbtn">搜索</a></th>
                    <th><th>
                    <th><th>
                    <th><th>
                    <th><th>            
                </tr>
                <tr>
                  <th id="tablehead1">#</th>
                  <th id="tablehead2">Header</th>
                  <th id="tablehead3">Header</th>
                  <th id="tablehead4">Header</th>
                  <th id="tablehead5">Header</th>
                  <th id="tablehead6"colspan="2" text-align:center>信息管理</th>
                 
                </tr>
              </thead>
              <tbody id="info_tbody">
                <tr>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><button id="correctbtn" class="btn btn-mini btn-success" type="button">修改</button></td>
                  <td><button id="canclebtn" class="btn btn-mini btn-success" type="button" onclick="cancelbtn(this)">删除</button></td>
                </tr>
                <tr>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><input class="form-control" placeholder="101" type="text"></td>
                  <td><button class="btn btn-mini btn-success" type="button">修改</button></td>
                  <td><button class="btn btn-mini btn-success" type="button" onclick="cancelbtn(this)">删除</button></td>
                </tr>
 
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
</body>
</html>