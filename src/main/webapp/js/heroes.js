function renderHeroTable(heroes) {
    heroes.forEach(hero => {
        $('#heroesTableBody').append(`<tr>
        <td>${hero.name}</td>
        <td>${hero.profession.name}</td>
        <td>${hero.race}</td>
        <td>${hero.profession.hp}</td>
        <td>${hero.profession.mana}</td>
        <td id='icon-${hero.id}'></td>
        <td id='hero-${hero.id}'>
            <a href='/HeroApp/hero.jsp?hero_id=${hero.id}'><i class='fas fa-edit'></i></a>
            <a><i class='far fa-trash-alt' data-toggle='modal' data-target='#deleteHeroModal' id='modal-${hero.id}'></i></a>
        </td>
        </tr>`);
        if (hero.heroIcon){
            $(`#icon-${hero.id}`).html(`<img class='profession-image-icon' src='${hero.heroIcon}'/>`);    
        }
        const button = $(`#modal-${hero.id}`);
        button.click(() => {
            const deleteButton = $("#deleteHeroModalDeleteButton");
            deleteButton.click(() => {
                $.ajax({
                    url: "/HeroApp/api/hero/" + hero.id + "/delete",
                    type: 'GET',
                    contentType: 'application/json',
                }).done(() => {
                    window.location.reload();
                }).fail(() => {
                    alert('ERROR');
                });
            });
            $("#deleteHeroModalName").html(hero.name);
        });
    });
    $('#deleteAllHeroModalDeleteButton').click(() => {
        $.ajax({
            url: "/HeroApp/api/heroes/delete",
            type: 'GET',
            contentType: 'application/json',
        }).done(() => {
            window.location.reload();
        }).fail(() => {
            alert('ERROR');
        });
    })
    $(".no-heroes").hide();
    $(".heroes").show();

}






function getHeroes() {

    $.ajax({
        url: "/HeroApp/api/heroes",
        type: 'GET',
        contentType: 'application/json',
    }).done((data) => {
        if (data.length && data.length > 0) {
            renderHeroTable(data)
        }

    }).fail(() => {
        alert('ERROOOOOOR');
    });
}

$(document).ready(() => {
    getHeroes();
});