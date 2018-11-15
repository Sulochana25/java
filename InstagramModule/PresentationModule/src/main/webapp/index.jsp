<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="Style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>GGK Snap</title>
</head>
<body style="overflow:hidden">
<div class="row">
    <div class="col-9" id="particles-js">
        <div class="container overdiv">
            <h1>Keep Your Friends Closer</h1>
            <h6>Enemies too</h6>
        </div>
    </div>
    <div class="login-form">
        <div class="row signup-signin">
            <div class="col-sm-6 "><a style="color:#ff8040" href="SignUp.jsp" target="auth-frame">SignUp</a></div>
            <div class="col-sm-6"><a style="color:#ff8040" href="LogIn.jsp" target="auth-frame">LogIn</a></div>
        </div>
        
        <div class="col-sm-12">
            <iframe class="container frame-class" src="LogIn.jsp" name="auth-frame" id="frame1"></iframe>
        </div>
    </div>
</div>
<script src="particles.js"></script>
<script src="app.js"></script>
</body>
</html>