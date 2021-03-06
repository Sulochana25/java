<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="SignupStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="container">
<jsp:useBean id="signupBean" class="com.social.instagram.logic.SignUpBean" scope="application"/>  
<form action="SignUp" method="post"  id="signForm">
    <table>
        <thead>
        </thead>
        <tbody>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstname" value='<jsp:getProperty property="firstName" name="signupBean" />'></td>
            <br><br>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastname" value='<jsp:getProperty property="lastName" name="signupBean" />'></td>
            <br><br>
        </tr>
        <tr>
            <td>Email ID:</td>
            <td><input type="email" name="emailid" value='<jsp:getProperty property="emailId" name="signupBean" />'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="userpwd" id="userpwd"></td>
        </tr>
         <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="cnfrmpwd" id="cnfrmpwd"></td>
        </tr> 
                <tr>
            <td colspan="2" style="text-align:center;">
                <button class="btn btn-primary" type="submit">Sign Up</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>