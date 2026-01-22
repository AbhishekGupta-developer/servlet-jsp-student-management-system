<%@ page language="java" contentType="text/html; charset=UTF-8" %>
  <html>

  <head>
    <title>Student profile</title>
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

    <style>
        body {
            background-color: #f4f6f9;
        }
        .profile-header {
            background: linear-gradient(135deg, #0d6efd, #6610f2);
            color: white;
            padding: 40px 20px;
            border-radius: 0 0 20px 20px;
        }
        .profile-avatar {
            width: 120px;
            height: 120px;
            background-color: #fff;
            color: #0d6efd;
            font-size: 48px;
            font-weight: bold;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: auto;
        }
    </style>
  </head>

  <body>
    <%
      String studentId = request.getParameter("id");
    %>
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

        <div class="container-fluid p-0">

    <!-- Profile Header -->
    <div class="profile-header text-center">
        <div class="profile-avatar mb-3" id="student-initials">
            
        </div>
        <h2 class="mb-1" id="studentName"></h2>
        <p class="mb-0">Student ID: <span id="studentId"></span></p>
    </div>

    <!-- Content Section -->
    <div class="container mt-5">
        <div class="row g-4">

            <!-- Student Information -->
            <div class="col-md-6">
                <div class="card shadow-sm h-100">
                    <div class="card-header bg-primary text-white">
                        Student Information
                    </div>
                    <div class="card-body">
                        <p><strong>Full Name:</strong> <span id="student-info-name"></span></p>
                        <p><strong>Email:</strong> <span id="student-info-email"></span></p>
                        <p><strong>Phone:</strong> <span id="student-info-phone"></span></p>
                        <p><strong>Student ID:</strong> <span id="student-info-student-id"></span></p>
                    </div>
                </div>
            </div>

            <!-- Course Information -->
            <div class="col-md-6">
                <div class="card shadow-sm h-100">
                    <div class="card-header bg-success text-white">
                        Course Information
                    </div>
                    <div class="card-body">
                        <p><strong>Course Name:</strong> <span id="course-info-name"></span></p>
                        <p><strong>Course ID:</strong> <span id="course-info-id"></span></p>
                        <p><strong>Duration:</strong> <span id="course-info-duration"></span> Months</p>
                        <p><strong>Fee:</strong> ₹<span id="course-info-fee"></span></p>
                    </div>
                </div>
            </div>

        </div>

        <!-- Action Buttons -->
        <div class="row mt-4">
            <div class="col text-center">
                <button class="btn btn-primary me-2" onClick="updateProfile(<%= studentId %>)">Update Profile</button>
                <button class="btn btn-outline-secondary" onclick="downloadPage()">Download Details</button>
            </div>
        </div>
    </div>

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
          loadStudentProfile(id);
        }
      };

      function loadStudentProfile(id) {
        event.preventDefault(); // stop form reload
        fetch("<%=request.getContextPath()%>/api/student/profile?id=" + id)
          .then(res => res.json())
          .then(student => {

            document.getElementById("student-initials").innerHTML = getInitials(student.studentName);
            document.getElementById("studentId").innerHTML = id;
            document.getElementById("studentName").innerHTML = student.studentName;

            document.getElementById("student-info-name").innerHTML = student.studentName;
            document.getElementById("student-info-email").innerHTML = student.studentEmail;
            document.getElementById("student-info-phone").innerHTML = student.studentPhone;
            document.getElementById("student-info-student-id").innerHTML = id;

            document.getElementById("course-info-name").innerHTML = student.courseName;
            document.getElementById("course-info-id").innerHTML = student.courseId;
            document.getElementById("course-info-duration").innerHTML = student.courseDuration;
            document.getElementById("course-info-fee").innerHTML = student.courseFee;
          })
          .catch(err => console.error(err));
      }

      function getInitials(name) {
        return name
          .split(" ")
          .map(word => word[0])
          .join("");
      }

      function updateProfile(id) {
        event.preventDefault(); // stop form reload
        window.location.href = "<%=request.getContextPath()%>/student-update.jsp?id=" + id;
      }

      function downloadPage() {
        window.alert("Coming soon!");
        return;
      }
    </script>
  </body>

  </html>