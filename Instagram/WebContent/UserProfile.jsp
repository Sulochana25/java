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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="jquery.js"></script>
    <title>GGK Snap</title>
    
    
</head>
<body>
<%
        Connection con = (Connection) application.getAttribute("connection");
Statement st = con.createStatement();
%>
<div class="mr-5 row mb-4 mt-4" >
    <div class="col-8"></div>
    <div class="col-3 user-details">        
        <span class="userName user-name">
        <%
            
            ResultSet userName = st.executeQuery(
                "Select * from SnapGGKUsers where id=" + (int) request.getSession().getAttribute("userid"));
            while(userName.next()) {
        %>
        <%=userName.getString("firstname") %>&nbsp;<%=userName.getString("lastname") %>
        <%} %>
        </span>
        <%
            ResultSet displayPicture = st.executeQuery(
				"Select * from userDetails where userid=" + (int) request.getSession().getAttribute("userid"));
            while(displayPicture.next()) {
        %>
        <img src='./images/<%=displayPicture.getString("displayPicture")%>' class="user-image userImage" onclick="userEdit()" width="50" height="50">
        <%} %>
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
    <%
        st = con.createStatement();
	    ResultSet resultSet = st.executeQuery(
			"Select * from posted_pictures where userid=" + (int) request.getSession().getAttribute("userid"));
        
    %>
    <div class="col-lg-6 main main-content" >
    <% while(resultSet.next()) { %>
        <div class="rounded m-5">
            <div class="card">
                <div class="card-header">
                   <%=resultSet.getString("datePosted") %>
                </div>
                <div class="card-body">
                    <img src='./images/<%=resultSet.getString("pictureblob")%>' class="rounded new-post">
                </div>
                <div class="card-footer text-muted">
                   <%=resultSet.getString("postdescription")
                    %>
                </div>
            </div>
        </div>
        
       <%} %>            
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
                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>

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