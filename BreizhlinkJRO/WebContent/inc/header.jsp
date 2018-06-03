<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
    <title>${title}</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="static/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <style>
    	.margtop{
			height:100px;
			padding-top:10px;
		}
		.padtop{
			padding-top:20vh;
		}
		 body {
		    display: flex;
		    min-height: 100vh;
		    flex-direction: column;
		    background-image: url("static/img/bg.jpg");
		    background-repeat:no-repeat;
		    background-size: 100% 100%;
		    background-position: fixed;
		    
		  }
		  footer{
		  width: 100%;
		  position: relative!important;
		  bottom:0!important;
		  }
		  .f40{
		  	font-size:20px !important;
		  }
		  .f50{
		  	font-size:30px !important;
		  }
		  .typ{
		  	position: relative!important;
		  	font-size: 40px;
		  	top:-20px!important;
		  }
		  .hei4{
		  	height: 40px;
		  }
		  .hei50{
		  	height: 150px;
		  	margin-top: -20px;
		  	background-color: rgba(0, 0, 0, 0.2);
		  }
		  .bgcn02{
		  	background-color: rgba(0, 0, 0, 0.2);
		  }
		  .inplink{
		  	background-color:rgba(0, 0, 0, 0.2)!important;
		  	padding-left: 10px!important;
		  	padding-right: 10px!important;
		  	color: #ffffff;
		  }
		  .tshadb{
		  	text-shadow: 0 0 10px #000000;
		  }
		  .ptot{
		  	padding: 10px;
		  }
		  .rad10{
		  border-radius:10px;
		  }
		  .oswald{
		  	font-family: 'Oswald', sans-serif;
		  }
			.linkg{
			color:#000000;
			text-shadow: 0 0 4px #ffffff;
			}
			.linkg:hover{
			color:#000000;
			text-shadow: 0 0 4px #DC143C;
			}
			.tmdpp {
				position: relative;
				top: 20px;
				font-size:20px;
			}
			.sectpres1{
				min-height:25vh;
			}
			.sectpres2{ 
				height:45vh;
				padding-top: 10vh;
			}
			.sectpres3{
				height:65vh;
				padding-top: 10vh;
			}
			.formgen{
				padding: 20px!important;
				border-radius:10px;
				border:1px solid #ffffff;
			}
			.margbot{
				margin-bottom: 70px;
			}
			.Show11, .Show12{
				padding-bottom:20px!important;
			}
			.target{
			}
			.target1{
				
				display:none;
			}
		  main {
		    flex: 1 0 auto;
		  }
    </style>
</head>