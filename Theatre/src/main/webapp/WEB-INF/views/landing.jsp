<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
<title>LandingPage</title>
<style>
 .body{
    margin: 0px;
    padding: 0px; 
    background-color:rgba( 71, 147, 227, 1);
    color: white;

 }  
 .content{

    align-items: center;
 } 

.outbox{
    display: flex;
    flex-direction: row;
    align-items:center;
} 

.fbox{

background-color:  #1c1c1c;
color:#45f3ff;
width: 40%;
height: 100px;



}

.box{

    background-color:  #1c1c1c;
    color:#45f3ff;
    width: 100%;
    height: 100px;
    
   

}
.lbox{
    background-color:  #1c1c1c;
    color:#45f3ff;
    width: 5%;
    height: 100px;

}


a{
    padding: 3px;
    margin: 15px;
   
    
    
}

a:link{

color:white;

}

a:hover{
    color:#45f3ff;
}
a:visited{

    color: white;
}
</style>


</head>
<body class="body">
    <div class="outbox">

        <div class="fbox">
                  <a href="landing"><h1>For Theatre</h1></a>

        </div>

        <div class="box">

              <h1></h1>
              <h3>
                 <a href="main">ALL MOVIES</a>
                 <a href="cur">OUR MOVIES</a>
                 <a href="det">DETAILS</a>
                </h3>
                 

        </div>

        <div class="lbox" >
            <h1></h1>
            
            <a href="index">logout</a>

        </div>
    </div>    
<div class="content">

    <h1>Welcome</h1>

</div>

</body>