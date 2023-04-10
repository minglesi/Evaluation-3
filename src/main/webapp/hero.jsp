<jsp:include page="header.jsp">
    <jsp:param name="activePage" value="hero" />
</jsp:include>

<div class="container-body">
    <div id="container-form">
        <div class="jumbotron">
            <div class="row">
                <div class="form-group col-xl-6">
                    <label for="name">Name</label>
                    <input type="text" class="form-control has-validation" id="name" name="name" placeholder="your hero's name..."
                        required maxlength="30">
                    <div class="invalid-feedback" id="nameError"></div>
                </div>

                <div class="form-group col-xl-6">
                    <label for="race">Race</label>
                    <select class="custom-select has-validation" name="race" id="race" required>
                        <option value="" selected disabled hidden>Select a race</option>
                        <option value="Human" id="Human">Human</option>
                        <option value="Orc" id="Orc">Orc</option>
                        <option value="Elf" id="Elf">Elf</option>
                        <option value="Goblin" id="Goblin">Goblin</option>

                    </select>
                    <div class="invalid-feedback" id="raceError"></div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-xl-6">
                    <label for="profession">Profession</label>
                    <select class="custom-select has-validation" name="profession" id="professionId" required>
                        
                    </select>
                    </br>
                    <div class="invalid-feedback" id="professionIdError"></div>

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-secondary btn-sm float-right" id="create-profession-btn"
                        data-toggle="modal" data-target="#professionModal">Create new
                    </button>
                </div>

                <div class="form-group col-xl-6">
                    <label>Hero Icon</label>
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="heroIcon" name="icon" onchange="previewFile();">
                            <label class="custom-file-label" for="heroIcon" id="heroIconLabel">Choose file</label>
                        </div>
                    </div>
                </div>
                <img class="hero-image" src="" alt="Hero Image" id="heroImage" />
            </div>

            <button onClick='sendHeroForm();' class="btn btn-primary" id="saveHero">Save</button>
            <a href="/HeroApp/heroes.jsp">
                <button type="button" id="close-btn" class="btn btn-primary">Cancel</button>
            </a>

        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="professionModal" tabindex="-1" aria-labelledby="professionModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="professionModalLabel">New Profession</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="professionName">Choose a name for your new profession: </label>
                        <input type="text" class="form-control has-validation" id="professionName" name="professionName"
                            placeholder="new profession name..." maxlength="30" required>
                        <div class="invalid-feedback" id="professionNameError"></div>
                    </div>

                    <div class="form-group">
                        <label for="professionHp">Choose your amount of HP: </label>
                        <input type="range" class="form-range has-validation" id="professionHp" name="professionHp"
                            placeholder="your HP..." min="1" max="100" value="100" onchange="changeHp();">
                        <span id="professionHpValue">100</span>
                        <div class="invalid-feedback" id="professionHpError"></div>
                    </div>

                    <div class="form-group">
                        <label for="professionMana">Choose your amount of Mana: </label>
                        <input type="range" class="form-range has-validation" id="professionMana" name="professionMana"
                            placeholder="your Mana..." min="0" max="99" value="0" onchange="changeMana();">
                        <span id="professionManaValue">0</span>
                        <div class="invalid-feedback" id="professionManaError"></div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button onClick='sendProfessionForm();' class="btn btn-primary" id="professionSubmit">Add</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript" src="js/hero.js"></script>
<jsp:include page="footer.jsp" />