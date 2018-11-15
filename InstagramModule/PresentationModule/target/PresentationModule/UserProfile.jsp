<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="jquery.js"></script>
    <title>GGK Snap</title>
    
    
</head>
<body>

<div class="mr-1 row mb-1 mt-1 head" >
    <div class="col-8"></div>
    <div class="col-3 user-details">        
        <span class="userName user-name">
        <jsp:useBean id="userDetailsBean" class="org.CommonUtils.UserDetailsBean" scope="application"/>   
        <jsp:getProperty property="firstName" name="userDetailsBean" />
        <jsp:getProperty property="lastName" name="userDetailsBean" />
        
        </span>
       
        <img src='images/<jsp:getProperty property="displayPicture" name="userDetailsBean" />' class="user-image userImage" onclick="userEdit()" width="50" height="50">
      
    </div>
    <div class="col-1 logout-button">
        <form action="Logout" method="post">
            <button class="btn btn-sm btn-link logout-btn" type="submit">Logout</button>
        </form>
    </div>
</div>
<div class="row new-post-div">
    <div class="col-lg-3 left-sidebar">
        <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
            + New Post
        </button>
        <br>
    </div>
   
    <div class="col-lg-6 main main-content" >
    <div class="rounded m-5">
            <div class="card">
                <div class="card-header">
                   Posted By username 
                </div>
                <div class="card-body">
                    <img src="images/3.jpg" class="rounded new-post">
                </div>
                <div class="card-footer text-muted">
                 Sample Description
                </div>
            </div>
        </div>
        <div class="rounded m-5">
            <div class="card">
                <div class="card-header">
                   Posted By username 
                </div>
                <div class="card-body">
                    <img src="images/4.jpg" class="rounded new-post">
                </div>
                <div class="card-footer text-muted">
                 Sample Description
                </div>
            </div>
        </div>
    <c:forEach items="${posts}" var="post">
        <div class="rounded m-5">
            <div class="card">
                <div class="card-header">
                   Posted By <jsp:getProperty property="firstName" name="userDetailsBean" /> <jsp:getProperty property="lastName" name="userDetailsBean" /> 
                </div>
                <div class="card-body">
                    <img src="images/<c:out value='${post.picture}'/>" class="rounded new-post">
                </div>
                <div class="card-footer text-muted">
                 <c:out value='${post.description}'/>
                </div>
            </div>
        </div>        
      </c:forEach>          
    </div>
    

    <div class="col-lg-3 right-sidebar"></div>
</div>
<form action="UploadPost" method="post" enctype="multipart/form-data" id="one">
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">New Post</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="file btn btn-sm btn-primary postbutton">
                        + Upload File
                        <input type="file" name="myImage" accept="image/*" class="fileinput" onchange="readURL(this);"/>
                    </div>
                    <br><br>
                    <img id="displayPhoto"></img>

                    <div class="form-group">
                        <label for="comment">Description:</label>
                        <textarea class="form-control" rows="3" id="description" name="picdesc"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal" style="background-color:#ff0000">Close</button>

                    <button type="submit" class="btn btn-sm btn-primary" name="uploadbutton" >Upload</button>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="jQuery.js" type="text/javascript"></script>
<script type="text/javascript">
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#displayPhoto').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    function userEdit() {
        window.location.href = "userEditDetails.jsp"
    }  
   

    
</script>
</body>
</html>