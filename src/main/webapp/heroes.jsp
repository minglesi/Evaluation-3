<jsp:include page="header.jsp">
    <jsp:param name="activePage" value="heroes" />
</jsp:include>


<div class="container-body">
    <div class="jumbotron">
        <div class="heroes">
            <h1 class="display-4">My Heroes list</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>Name</th>
                        <th>Profession</th>
                        <th>Race</th>
                        <th>Hp</th>
                        <th>Mana</th>
                        <th>Icon</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="heroesTableBody">
                </tbody>
            </table>
            <button type="button" class="btn btn-danger btn-lg float-right" data-toggle="modal" data-target="#deleteAllHeroModal">Delete List</button>
        </div>
        <div class="no-heroes">
            <h2 class="display-4">Nobody's here yet!</h2><br>
            <p class="lead">Ready for an adventure? </p>
            <p class="lead">Create a new Hero and let's get started!</p>
            <a class="btn btn-primary btn-lg" href="/HeroApp/hero.jsp" role="button">New Hero</a>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteHeroModal" tabindex="-1" aria-labelledby="deleteHeroModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteHeroModalLabel">Confirm action</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>If you delete <span id="deleteHeroModalName"></span>, it will be gone for good. Do you want to
                    proceed?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                <button class="btn btn-primary" id="deleteHeroModalDeleteButton">Delete</button>

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteAllHeroModal" tabindex="-1" aria-labelledby="deleteAllHeroModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteAllHeroModalLabel">Confirm action</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>If you confirm this action all heroes will dissapear</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                <button class="btn btn-primary" id="deleteAllHeroModalDeleteButton">Delete</button>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="js/heroes.js"></script>
<jsp:include page="footer.jsp" />