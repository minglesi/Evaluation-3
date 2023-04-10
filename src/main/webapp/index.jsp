<jsp:include page="header.jsp">
    <jsp:param name="activePage" value="index"/>
</jsp:include>


<div class="container-body">
  <div class="jumbotron">
    <h1 class="display-4">About this Web App</h1><br>
    <p class="lead">I made this web app as a project for my Dataart Trainee course. It's a simple application
                    intended to perform CRUD operations, using as an excuse the creation of Heroes. Here you
                    can create and store different Heroes in a database.</p>
    <hr class="my-4">
    <p>Remember when you where a kid dreaming about superheroes? Now you can create them!</p>
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/hero.jsp" role="button">New Hero</a>
  </div>
</div>

<jsp:include page="footer.jsp"/>
