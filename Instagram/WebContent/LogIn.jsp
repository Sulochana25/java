<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
    	crossorigin="anonymous">
        <link rel="stylesheet" href="LoginStyle.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="container">


    <form action="LogIn" method="post" name="form" target="_top"  onSubmit="validateForm()">
        <table>
            <thead></thead>
            <tbody>
                <tr>
                    <td>Email ID:</td>  
                    <jsp:useBean id="loginBean" class="com.social.instagram.logic.LoginBean" scope="application"/>                   
                    <td><input type="email" name="emailid" value='<jsp:getProperty property="emailid" name="loginBean" />'></td><br><br>
                     
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="userpwd" ></td><br><br>
                <tr >
                <br>
                    <td colspan="2" style="text-align:center;">
                    <button class="btn btn-primary" type="submit" value="Login">LogIn</button></td><br>
                </tr>
            </tbody>
        </table>
    Don't have an account? <a href="SignUp.jsp" target="auth-frame" >SignUp</a>
    </form>
  
    <script>
    	function validateForm(){
    		if(form.emailid.value=='' || form.userpwd.value==''){
    			alert("Enter all the fields");
    			window.location.href="index.jsp";
    		}
    	}
    </script>
</body>
</html>