<%@page import="com.huge.web.pojo.BusInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.huge.web.pojo.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- TODO -->
  <link rel="icon" href="../../../../favicon.ico">

  <title>搜索结果</title>

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
    <button id="tijiao" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault"
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
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="suc">Search</button>
      </form>
    </div>
  </nav>
  <!-- /导航栏 -->

  <main role="main" class="container">
    <!-- 日期分页 -->
    <nav aria-label="...">
      <ul class="pagination justify-content-center" id="pag">
        <li class="page-item disabled">
          <a class="page-link" href='#' tabindex="-1" >&lt;</a>
        </li>
        <% 
    	// 获取返回的日期string
		List list = (List)request.getAttribute("busInfoList");
		// String str = (String)request.getAttribute("list");
		String str = ((BusInfo)list.get(0)).getStartDate();
		//String str = (String)list.get(0);
		// 将string转换为date格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		// 获取当前日期是周几
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String[] arr = {"周日","周一","周二","周三","周四","周五","周六"};
		int dow = calendar.get(Calendar.DAY_OF_WEEK)-1;
		/* out.write("今天是周:"+arr[dow]); */
		// 计算下一天的日期
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		/* out.write("明天的日期:"+sdf.format(calendar.getTime())); */
		// 计算下一天是周几
		/* dow = calendar.get(Calendar.DAY_OF_WEEK)-1; */
		/* out.write("明天是周:"+arr[dow]); */
        %>
         <li class="page-item">
          <a class="page-link" href='#' ><%=str%></a>
        </li>
        <li class="page-item">
          <a class="page-link" href='#' ><%=sdf.format(calendar.getTime())%></a>
        </li>
        <%calendar.add(Calendar.DAY_OF_YEAR, 1); %>
        <li class="page-item">
          <a class="page-link" href='#' ><%=sdf.format(calendar.getTime())%></a>
        </li>
         <%calendar.add(Calendar.DAY_OF_YEAR, 1); %>
        <li class="page-item active">
          <a class="page-link" href='#' ><%=sdf.format(calendar.getTime())%>
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <%calendar.add(Calendar.DAY_OF_YEAR, 1); %>
        <li class="page-item">
          <a class="page-link" href="#" ><%=sdf.format(calendar.getTime())%></a>
        </li>
       <%calendar.add(Calendar.DAY_OF_YEAR, 1); %>
        <li class="page-item">
          <a class="page-link" href="#" ><%=sdf.format(calendar.getTime())%></a>
        </li>
         <%calendar.add(Calendar.DAY_OF_YEAR, 1); %>
        <li class="page-item">
          <a class="page-link" href="#" ><%=sdf.format(calendar.getTime())%></a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">&gt;</a>
        </li>
      </ul>
    </nav>
    <!-- /日期分页 -->

    <!-- 筛选 -->
    <ul class="list-group list-group-flush">
      <li class="list-group-item">
        <span>发车时间</span>
       <ul class="list-group list-group-flush">
      <li class="list-group-item" id="rad">
        <span>发车时间</span>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" id="morning" value="morning" name="mor" >
          <label class="form-check-label" for="morning"  value="morning">上午(0-12点)</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio"  id="noon" value="noon" name="mor" >
          <label class="form-check-label" for="noon" value="noon">中午(12-14点)</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" id="下午(14-18)" value="afternoon" name="mor" checked="checked">
          <label class="form-check-label" for="下午(14-18)"  name="mor" value="afternoon">下午(14-18)</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" id="晚上(18-6点)" value="evening" name="mor">
          <label class="form-check-label" for="晚上(18-6点)"  name="mor" value="evening">晚上(18-6点)</label>
        </div>
      </li>
      <!-- TODO 抄携程 -->
      <li class="list-group-item" id="start">出发车站: <span>${busInfoList[0].startStation}</span></li>
      <li class="list-group-item" id="end">到达车站: <span>${busInfoList[0].endStation}</li>
    </ul>
    <!-- /筛选 -->

    <!-- 余票信息 -->
    <div class="table-responsive-lg">
      <table class="table table-hover table-bordered">
        <thead class="thead-dark">
          <tr>
            <th scope="col">发车时间</th>
            <th scope="col">车次</th>
            <th scope="col">发站/到站</th>
            <th scope="col">运行时间</th>
            <th scope="col">参考票价</th>
            <th scope="col">剩余票量</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach items="${busInfoList}" var="busInfo"> 
        	<tr>
            <!-- TODO 垂直居中 -->
            <th scope="row">${busInfo.startTime}</th>
            <!-- TODO 添加图标 -->
            <td id="busid">${busInfo.id}</td>
            <td>${busInfo.startStation}
              <br>${busInfo.endStation}</td>
            <td>${busInfo.costTimeCarstyle}</td>
            <!-- TODO 添加价格高亮显示 -->
            <td>${busInfo.price}</td>
            <td>${busInfo.leftTicket}</td>
            <td>
              <button type="submit" class="btn btn-primary" id="cal" onclick="clickbtn(this)">立即购买</button>
            </td>
          </tr>
        	</c:forEach>
    
          <%-- <tr id="lis">
            <th scope="row">${busInfoList}</th>
            <td>${busInfoList.get(1)}</td>
              <td></td>
            <td></td>
            <td>全价￥330</td>
            <td>充足</td>'
            <td>
             <button type="button" class="btn btn-primary">立即购买</button>
            </td>
          </tr> --%>
        </tbody>
      </table>
    </div>
    <!-- /余票信息 -->

    <!-- 结果分页 -->
    <nav aria-label="Page navigation example">
      <ul class="pagination justify-content-end">
        <li class="page-item disabled">
          <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">Next</a>
        </li>
      </ul>
    </nav>
    <!-- /结果分页 -->

  </main>
  <!-- /.container -->

  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="../js/bootstrap.bundle.min.js"></script>
  <script src="/js/static/search.js"></script>
  <script src="/js/static/by.js"></script>
   <script src="/js/jquery.cookie.js"></script>
</body>

</html>