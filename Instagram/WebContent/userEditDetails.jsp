<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.io.IOException,
                    java.sql.Connection,
                    java.sql.ResultSet,
                    java.sql.ResultSetMetaData,
                    java.sql.Statement,
                    javax.servlet.ServletContext,
                    javax.servlet.ServletException,
                    javax.servlet.annotation.WebServlet,
                    javax.servlet.http.HttpServlet,
                    javax.servlet.http.HttpServletRequest,
                    javax.servlet.http.HttpServletResponse"
      %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="UserStyle.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="jquery.js"></script>
    <title>GGK Snap</title>
</head>

<style>
    .edit-user-form{
        margin-left: auto;
        margin-right: auto;
        width: 400px;
         
    }  
    .buttonForm{
      width:300px;
      display:inline-block;
     
      
    }
    .cancelForm{
        float:right;
    }
    body{
    background-color:#ebebeb;
    }
    .user-form{
    padding-top:50px;
    padding-bottom:50px;
    background-color:silver;
    }
</style>
<body>
<%
    Connection con = (Connection) application.getAttribute("connection");
    Statement st = con.createStatement();
    
    ResultSet details = st.executeQuery(
        "Select * from userDetails where userid=" + (int) request.getSession().getAttribute("userid"));
   
    details.next();
%>
<div class="container">
<div class="row ml-4 mt-4 user-form">
    <form class="edit-user-form" action="UpdateDetails" method="post" enctype="multipart/form-data" id="update" onsubmit="onSubmit()">
        <div class="form-group">
            <div class="file btn btn-sm btn-primary postbutton">
                 Change Picture
                <input type="file" name="myImage" accept="image/*" class="fileinput" onchange="readURL(this);" />
            </div>
            
            <br><br>           
            <img src='./images/<%=details.getString("displayPicture")%>' id="displayPhoto"></img>
           
        </div>
        <div class="form-group">
            <label for="FirstNameInput">First Name</label>
            <input type="text" class="form-control" id="FirstNameInput"  name="firstname" value='<%= details.getString("firstname") %>'>
        </div>
        <div class="form-group">
            <label for="LastNameInput">Last Name</label>
            <input type="text" class="form-control" id="LastNameInput"  name="lastname" value='<%= details.getString("lastname") %>'>
        </div>
        <div class="form-group">
            <label for="DoBInput">Date of Birth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input type="date" id="DoBInput" name="dob" min="1990-01-01" max="2018-01-01" value='<%= details.getString("DoB") %>'>
        </div>
        <div class="form-group">
            <label for="EmailInput">Email</label>
            <input type="text" class="form-control" id="EmailInput"  name="emailid" value='<%= details.getString("emailid") %>'>
        </div>
        <div class="form-group">
            <label for="PasswordInput">Password</label>
            <input type="text" class="form-control" id="PasswordInput" name="password" value='<%= details.getString("password") %>'>
        </div>
        <div class="row ml-4 mt-4 buttonForm">
        <button type="submit" class="btn btn-primary submitForm" >Submit</button>
       <button type="button" class="btn btn-primary cancelForm" onclick="goBack()">Back To Home</button> 
       </div>
    </form>
</div>
</div>


<script>
    function onSubmit() {
    	alert("Details Uploaded Successfully");
      
    }  
    
    function goBack(){
    	window.location.href="UserProfile.jsp";
    }

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#displayPhoto').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
        
    }
     
    
</script>
</body>
</html>