<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tbanque | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <spring:url value="/resources/css/bootstrap.min.css" var="a"></spring:url>
    <spring:url value="/resources/css/font-awesome.min.css" var="b"></spring:url>
    <spring:url value="/resources/css/ionicons.min.css" var="c"></spring:url>
    <spring:url value="/resources/css/morris/morris.css" var="d"></spring:url>
    <spring:url value="/resources/css/jvectormap/jquery-jvectormap-1.2.2.css" var="e"></spring:url>
    <spring:url value="/resources/css/datepicker/datepicker3.css" var="f"></spring:url>
    <spring:url value="/resources/css/daterangepicker/daterangepicker-bs3.css" var="g"></spring:url>
    <spring:url value="/resources/css/iCheck/all.css" var="h"></spring:url>
    <spring:url value="/resources/css/style.css" var="i"></spring:url>
    <link rel="stylesheet" href="${a}">
    <link rel="stylesheet" href="${b}">
    <link rel="stylesheet" href="${c}">
    <link rel="stylesheet" href="${d}">
    <link rel="stylesheet" href="${e}">
    <link rel="stylesheet" href="${f}">
    <link rel="stylesheet" href="${g}">
    <link rel="stylesheet" href="${h}">
    <link rel="stylesheet" href="${i}">
    <!-- les java include -->

    <spring:url value="/resources/js/jquery.min.js" var="aaj"></spring:url>  
    <spring:url value="/resources/js/jquery-ui-1.10.3.min.js" var="aj"></spring:url>
    <spring:url value="/resources/js/bootstrap.min.js" var="bj"></spring:url>
    <spring:url value="/resources/js/plugins/daterangepicker/daterangepicker.js" var="cj"></spring:url>
    <spring:url value="/resources/js/plugins/chart.js" var="dj"></spring:url>
    <spring:url value="/resources/js/plugins/iCheck/icheck.min.js" var="ej"></spring:url>
    <spring:url value="/resources/js/plugins/fullcalendar/fullcalendar.js" var="fj"></spring:url>
    <spring:url value="/resources/js/Director/app.js" var="gj"></spring:url>
    <spring:url value="/resources/js/Director/dashboard.js" var="hj"></spring:url>
    
    
    
    <!-- fin des java include --> 
      </head>
      <body class="skin-black">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="home" class="logo">
                TBanque
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                      
                        
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                <span>${nom} <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                <li class="dropdown-header text-center">Account</li>

             

                                        <li class="divider"></li>

                                        <li>
                                          <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </header>
                <div class="wrapper row-offcanvas row-offcanvas-left">
                    <!-- Left side column. contains the logo and sidebar -->
                    <aside class="left-side sidebar-offcanvas">
                        <!-- sidebar: style can be found in sidebar.less -->
                        <section class="sidebar">
                            <!-- Sidebar user panel -->
                           
                            <!-- search form -->
                           
                            <!-- /.search form -->
                            <!-- sidebar menu: : style can be found in sidebar.less -->
                            <ul class="sidebar-menu">
                                <li class="active">
                                    <a href="home">
                                        <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="transaction">
                                        <i class="fa fa-globe"></i> <span>Operation</span>
                                    </a>
                                </li>
                                                            </ul>
                        </section>
                        <!-- /.sidebar -->
                    </aside>

                    <aside class="right-side">

                <!-- Main content -->
                <section class="content">
					<section class="panel">
                                <header class="panel-heading">
                                 Retrait
                                </header>
                                <div class="panel-body">
                                  <form class="form-horizontal tasi-form" method="Post" action="retrait">
                                      <div class="form-group has-success">
                                          <label class="col-sm-2 control-label col-lg-2" >Montant</label>
                                    <div class="input-group m-b-10">
                                                  <span class="input-group-addon">$</span>
                                                  <input class="form-control" type="text" name="montant" >
                                                  <span class="input-group-addon">.00</span>
                                              </div>
                                              <div class="col-lg-offset-2 col-lg-10">
                                              <div class="checkbox">
                                                  <label>
                                                      <input type="checkbox" name="retracted" value="true"> Retracted
                                                  </label>
                                              </div>
                                          </div>
                                              <div class="col-lg-offset-2 col-lg-10">
                                               <button type="submit" class="btn btn-info">Valider</button>
                                          </div>
                                          
                                      </div>
                               
                                      
                                  </form>
                                </div>
                                <!-- versement -->
                                       <header class="panel-heading">
                                 Versement
                                </header>
                                <div class="panel-body">
                                  <form class="form-horizontal tasi-form" method="Post" action="versement">
                                      <div class="form-group has-success">
                                          <label class="col-sm-2 control-label col-lg-2" for="inputSuccess">Montant</label>
                                                <div class="input-group m-b-10">
                                                  <span class="input-group-addon">$</span>
                                                  <input class="form-control" type="text" name="montant" >
                                                  <span class="input-group-addon">.00</span>
                                              </div>
                                               <label class="col-sm-2 control-label col-lg-2" for="inputSuccess">Numero du compte</label>
                                               <div class="col-lg-10">
                                              <input class="form-control" id="inputSuccess" name="comptenumber" type="text">
                                          </div>
                                          <br>
                                         <div class="col-lg-offset-2 col-lg-10">
                                               <button type="submit" class="btn btn-info">Valider</button>
                                          </div>
                                      </div>
                                      </div>
                          
                                      
                                  </form>
                                </div>
                            </section>
                            		
                            
                </section>
                <!--  table affichage -->
                
                

                
                
                
                <!--  fin tables affichage -->
                <!-- /.content -->
                <div class="footer-main">
                    Copyright &copy Tbanque, ensa agadir 2016
                </div>
            </aside><!-- /.right-side -->

        </div><!-- ./wrapper -->


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${aaj}" type="text/javascript"></script>

        <script src="${aj}" type="text/javascript"></script>
        <script src="${bj}" type="text/javascript"></script>
        <script src="${cj}" type="text/javascript"></script>
        <script src="${dj}" type="text/javascript"></script>
        <script src="${ej}" type="text/javascript"></script>
        <script src="${fj}" type="text/javascript"></script>
        <script src="${gj}" type="text/javascript"></script>
        <script src="${hj}" type="text/javascript"></script>
    
    
        <!-- Director for demo purposes -->
        <script type="text/javascript">
            $('input').on('ifChecked', function(event) {
                // var element = $(this).parent().find('input:checkbox:first');
                // element.parent().parent().parent().addClass('highlight');
                $(this).parents('li').addClass("task-done");
                console.log('ok');
            });
            $('input').on('ifUnchecked', function(event) {
                // var element = $(this).parent().find('input:checkbox:first');
                // element.parent().parent().parent().removeClass('highlight');
                $(this).parents('li').removeClass("task-done");
                console.log('not');
            });

        </script>
        <script>
            $('#noti-box').slimScroll({
                height: '400px',
                size: '5px',
                BorderRadius: '5px'
            });

            $('input[type="checkbox"].flat-grey, input[type="radio"].flat-grey').iCheck({
                checkboxClass: 'icheckbox_flat-grey',
                radioClass: 'iradio_flat-grey'
            });
</script>
<script type="text/javascript">
    $(function() {
                "use strict";
                //BAR CHART
                var data = {
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: [
                        {
                            label: "My First dataset",
                            fillColor: "rgba(220,220,220,0.2)",
                            strokeColor: "rgba(220,220,220,1)",
                            pointColor: "rgba(220,220,220,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [65, 59, 80, 81, 56, 55, 40]
                        },
                        {
                            label: "My Second dataset",
                            fillColor: "rgba(151,187,205,0.2)",
                            strokeColor: "rgba(151,187,205,1)",
                            pointColor: "rgba(151,187,205,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [28, 48, 40, 19, 86, 27, 90]
                        }
                    ]
                };
            new Chart(document.getElementById("linechart").getContext("2d")).Line(data,{
                responsive : true,
                maintainAspectRatio: false,
            });

            });
            // Chart.defaults.global.responsive = true;
</script>
</body>
</html>