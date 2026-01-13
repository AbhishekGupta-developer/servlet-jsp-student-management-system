<%@ page language="java" contentType="text/html; charset=UTF-8" %>
  <html>

  <head>
    <title>Update student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="index.jsp">
        <img src="images/logo.png" width="100px" alt="logo">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="student-register.jsp">Register Student <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Contact Us</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
              Courses
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Java SE</a>
              <a class="dropdown-item" href="#">Java EE / Jakarta EE</a>
              <a class="dropdown-item" href="#">Spring Boot and Microservices</a>
              <a class="dropdown-item" href="#">Gen AI</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">DSA with Java</a>
            </div>
          </li>
          <!-- <li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
          </li> -->
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
    <div class="container">
      <%
        String studentId = request.getParameter("id");
      %>
      <br>
      <h1>Update Student</h1>
    
      <form>
        <div class="form-row">
          <div class="form-group col-md-12 alert alert-primary" role="alert"><h3 style="padding-left: 10px;">Student ID: <%= studentId %></h3></div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="studentName">Name</label>
            <input type="text" class="form-control" id="studentName" placeholder="Enter your full name" required>
          </div>
          <div class="form-group col-md-6">
            <label for="studentEmail">Email</label>
            <input type="email" class="form-control" id="studentEmail" placeholder="Enter your email" required>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="studentPhone">Phone</label>
            <input type="number" class="form-control" id="studentPhone" placeholder="+91 - xxxxx - xxxxx" required>
          </div>
          <div class="form-group col-md-2">
            <label for="studentName">Course Id</label>
            <input type="number" class="form-control" id="studentCourse" placeholder="Enter Course ID" required>
          </div>
        </div>
        <button type="submit" class="btn btn-primary" onclick="updateStudent(event)">Update</button>
        <button type="reset" class="btn btn-danger">Cancel</button>
      </form>
      <div id="successAlert" class="alert alert-success" role="alert" style="display: none;">
      </div>
      <div id="errorAlert" class="alert alert-danger" role="alert" style="display: none;">
      </div>
      <br><br><br><br><br><br>
    </div>
    
    <footer class="pt-4 my-md-5 pt-md-5 border-top">
      <div class="container">
        <div class="row">

          <div class="col-12 col-md">
            <img class="mb-2" src="images/logo.png" alt="Logo" width="100">
            <small class="d-block mb-3 text-muted">© 2026 - 2030</small>
          </div>

          <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Cool stuff</a></li>
              <li><a class="text-muted" href="#">Random feature</a></li>
              <li><a class="text-muted" href="#">Team feature</a></li>
              <li><a class="text-muted" href="#">Stuff for developers</a></li>
              <li><a class="text-muted" href="#">Another one</a></li>
              <li><a class="text-muted" href="#">Last time</a></li>
            </ul>
          </div>

          <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Resource</a></li>
              <li><a class="text-muted" href="#">Resource name</a></li>
              <li><a class="text-muted" href="#">Another resource</a></li>
              <li><a class="text-muted" href="#">Final resource</a></li>
            </ul>
          </div>

          <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Team</a></li>
              <li><a class="text-muted" href="#">Locations</a></li>
              <li><a class="text-muted" href="#">Privacy</a></li>
              <li><a class="text-muted" href="#">Terms</a></li>
            </ul>
          </div>

        </div>
      </div>
    </footer>


    <script>
      window.onload = function () {
        const id = "<%= studentId %>";
        if(id) {
          loadStudent(id);
        }
      };

      function loadStudent(id) {
        event.preventDefault(); // stop form reload
        console.log("Student id: " + id);
        fetch("<%=request.getContextPath()%>/api/student?id=" + id)
          .then(res => res.json())
          .then(student => {
            document.getElementById("studentName").value = student.name;
            document.getElementById("studentEmail").value = student.email;
            document.getElementById("studentPhone").value = student.phone;
            document.getElementById("studentCourse").value = student.courseId;
          })
          .catch(err => console.error(err));
      }

      function updateStudent(event) {
        event.preventDefault(); // stop form reload

        let id = "<%= studentId %>";
        let name = document.getElementById("studentName").value;
        let email = document.getElementById("studentEmail").value;
        let phone = document.getElementById("studentPhone").value;
        let course = document.getElementById("studentCourse").value;

        let apiParams = `?id=${id}&name=${name}&phone=${phone}&email=${email}&course=${course}`;

        fetch("<%=request.getContextPath()%>/api/student" + apiParams, {
          method: "PUT",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          }
        })
          .then(response => response.json())
          .then(data => {

            // hide both alerts first
            document.getElementById("successAlert").style.display = "none";
            document.getElementById("errorAlert").style.display = "none";

            if (data.status.toLowerCase().includes("success")) {
              document.getElementById("successAlert").innerText = data.status;
              document.getElementById("successAlert").style.display = "block";

              setTimeout(() => {
                window.location.href = "<%=request.getContextPath()%>/student-list.jsp";
              }, 2500);
            }
          })
          .catch(error => {
            document.getElementById("errorAlert").innerText = "Something went wrong!";
            document.getElementById("errorAlert").style.display = "block";
            console.log("Error:", error);
          });
      }
    </script>
  </body>

  </html>