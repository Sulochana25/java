
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="UserStyle.css">
    <link href="css/bootstrap-form-helpers.min.css" rel="stylesheet">
    <script src="js/bootstrap-formhelpers.min.js"></script>
   
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

<jsp:useBean id="userDetailsBean" class="org.CommonUtils.UserDetailsBean" scope="application"/>

<div class="container">
<div class="row ml-4 mt-4 user-form">
    <form class="edit-user-form" action="UpdateDetails" method="post" enctype="multipart/form-data" id="update"  onsubmit="onSubmit()">
        <div class="form-group">
            <div class="file btn btn-sm btn-primary postbutton">
                 Change Picture
                <input type="file" name="myImage" accept="image/*" class="fileinput" onchange="readURL(this);" />
            </div>
            
            <br><br>           
            <img src='images/<jsp:getProperty property="displayPicture" name="userDetailsBean" />' id="displayPhoto"></img>
           
        </div>
        <div class="form-group">
            <label for="FirstNameInput">First Name</label>
            <input type="text" class="form-control" id="FirstNameInput"  name="firstname" value='<jsp:getProperty property="firstName" name="userDetailsBean" />'>
        </div>
        <div class="form-group">
            <label for="LastNameInput">Last Name</label>
            <input type="text" class="form-control" id="LastNameInput"  name="lastname" value='<jsp:getProperty property="lastName" name="userDetailsBean" />'>
        </div>
        <%-- <div class="form-group">
            <label for="DoBInput">Date of Birth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input type="date" id="DoBInput" name="dob" min="1990-01-01" max="2018-01-01" value='<jsp:getProperty property="DoB" name="userDetailsBean" />'>
        </div> --%>
         <div class="form-group">
            <label for="Nationality">Nationality</label>
           
            <select name="country" class="custom-select">
                <option value='<jsp:getProperty property="country" name="userDetailsBean" />'><jsp:getProperty property="country" name="userDetailsBean"/></option>           
                <option value="Latvia">Latvia</option>
                <option value="Lebanon">Lebanon</option>
                <option value="Lesotho">Lesotho</option>
                <option value="Liberia">Liberia</option>
                <option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
                <option value="Liechtenstein">Liechtenstein</option>
                <option value="Lithuania">Lithuania</option>
                <option value="Luxembourg">Luxembourg</option>
                <option value="Macau">Macau</option>
                <option value="Macedonia">Macedonia</option>
                <option value="Madagascar">Madagascar</option>
                <option value="Malawi">Malawi</option>
                <option value="Malaysia">Malaysia</option>
                <option value="Maldives">Maldives</option>
                <option value="Mali">Mali</option>
                <option value="Malta">Malta</option>
                <option value="Marshall Islands">Marshall Islands</option>
                <option value="Martinique">Martinique</option>
                <option value="Mauritania">Mauritania</option>
                <option value="Mauritius">Mauritius</option>
                <option value="Mayotte">Mayotte</option>
                <option value="Mexico">Mexico</option>
                <option value="Micronesia">Micronesia, Federated States of</option>
                <option value="Moldova">Moldova, Republic of</option>
                <option value="Monaco">Monaco</option>
                <option value="Mongolia">Mongolia</option>
                <option value="Montserrat">Montserrat</option>
                <option value="Morocco">Morocco</option>
                <option value="Mozambique">Mozambique</option>                
                <option value="Western Sahara">Western Sahara</option>
                <option value="Yemen">Yemen</option>
                <option value="Yugoslavia">Yugoslavia</option>
                <option value="Zambia">Zambia</option>
                <option value="Zimbabwe">Zimbabwe</option>
            </select>
        

        </div>
        <div class="form-group">
            <label for="EmailInput">Email</label>
            <input type="text" class="form-control" id="EmailInput"  name="emailid" value='<jsp:getProperty property="emailid" name="userDetailsBean" />'>
        </div>
        <div class="form-group">
            <label for="PasswordInput">Password</label>
            <input type="text" class="form-control" id="PasswordInput" name="password" value='<jsp:getProperty property="password" name="userDetailsBean" />'>
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