<%@ include file="include/head.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring 실습</title>
    <style>
        .test{
            color: red;
        }
        #idtest{
            color: blue;
        }
    </style>
</head>
<body>
<%@ include file="include/headerBar.jsp" %>

<br/>
<div class="row" align="center" style="font-size: 2.0em">


    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container col-md-4">
          Home
        </div>
        <div class="container col-md-4">
            about
        </div>
        <div class="container col-md-4">
            contact
        </div>
    </nav>
</div>
<br/>
<div class="row">
    <div class="col-md-3" align="center">
        <p style="background-color: skyblue !important; font-size: 2.0em !important;">1</p>
    </div>
    <div class="col-md-3" align="center">
        <p style="background-color: rebeccapurple">1</p>
    </div>
    <div class="col-md-6" align="center">
        <p style="background-color: greenyellow">1</p>
    </div>
</div>

<br/><br/><br/>

<div class="row">
    <div class="col-md-6" align="center">
        <div class="row">
            <div class="col-md-6">
                <span style="font-size:20px;">2</span>
            </div>
            <div class="col-md-6">
                <span style="font-size:20px;">2</span>
            </div>
        </div>

    </div>
    <div class="col-md-6" align="center">
        <span style="font-size:20px;">1</span>
    </div>
</div>


<br/><br/><br/><br/><br/><br/><br/><br/>



<div class="page-header">
    <h1>Example page header <small>Subtext for header</small></h1>
</div>
<div class="row" align="center">
    <img  src="/resources/images/spring.png"/>

</div>


<div class="row">
    <div class="col-xs-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resources/images/spring.png"/>
        </a>
    </div>
</div>
<div class="alert alert-success" role="alert">...</div>
<div class="alert alert-info" role="alert">...</div>
<div class="alert alert-warning" role="alert">...</div>
<div class="alert alert-danger" role="alert">...</div>
<p id="idtest">ID TEST</p>
<img src="/resources/images/spring.png"/><br/>
<span class="test">HELLO WORLD !!~~~~~</span> <span class="test">Hello world 2</span>
<div class="row">
    <div class="col-md-6">
        test<br/>
    </div>
    <div class="col-md-6">
        test2<br/>
    </div>


</div>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="#">대문</a>
    </li>
    <li><a href="#">...</a></li>
    <li><a href="#">...</a></li>
</ul>


<ul class="nav nav-pills">
    <li class="active">
        <a href="#">대문</a>
    </li>
    <li><a href="#">...</a></li>
    <li><a href="#">...</a></li>
</ul>
<ol class="breadcrumb">
    <li><a href="#">Home</a></li>
    <li><a href="#">Library</a></li>
    <li class="active">Data</li>
</ol>
<sec:authorize access="isAuthenticated()">
    <a href="/user/list">회원 리스트 보기</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_TEST')">
   이 화면은 ROLE_TEST에서만 보입니다.
</sec:authorize>
</body>
</html>
