function renderProfessionsSelect(professions, profession = null) {
    const professionIdSelector = $("#professionId");
    professionIdSelector.html(`<option value="" selected disabled hidden>Select a profession</option>`);
    professions.forEach(profession => {
        professionIdSelector.append(`<option value='${profession.id}'>${profession.name}</option>`);
    });
    if (profession) {
        professionIdSelector.val(profession.id);
    }
}

function getProfessions(profession = null) {
    $.ajax({
        url: "/HeroApp/api/professions",
        type: 'GET',
        contentType: 'application/json',
    }).done((data) => {
        if (data.length && data.length > 0) {
            renderProfessionsSelect(data, profession);
        }

    }).fail(() => {
        alert('ERROR');
    });
}

function renderHeroData(data) {
    $('#heroImage').hide();
    $('#name').val(data.name);
    $('#race').val(data.race);
    $('#professionId').val(data.profession.id);
    if (data.heroIcon) {
        $('#heroImage').attr('src', data.heroIcon).show();
    }
}

function getHero(heroId) {
    $.ajax({
        url: "/HeroApp/api/hero/" + heroId,
        type: 'GET',
        contentType: 'application/json',
    }).done((data) => {
        if (data) {
            renderHeroData(data);
        }

    }).fail(() => {
        alert('ERROR');
    });
}

$(document).ready(() => {
    getProfessions();
    const heroId = getHeroId();
    if (heroId) {
        getHero(heroId);
    }
});

function sendHeroForm() {
    const name = $('#name').val();
    const race = $('#race').val();
    const professionId = $('#professionId').val();
    $(".has-validation").removeClass("is-invalid");

    const icon = $('#heroIcon')[0].files[0];
    if (icon) {
        const reader = new FileReader();
        reader.readAsDataURL(icon);
        reader.onloadend = () => {
            const heroIcon = reader.result;
            submitHeroAjax(name, race, professionId, heroIcon);
        }
    } else {
        const heroId = getHeroId();
        let heroIcon = null;
        if (heroId) {
            heroIcon = $('#heroImage').attr('src');
        }
        submitHeroAjax(name, race, professionId, heroIcon);
    }
}

function submitHeroAjax(name, race, professionId, heroIcon = null) {
    const heroSubmit = $('#heroSave');
    heroSubmit.prop('disabled', true);
    const heroId = getHeroId();
    $.ajax({
        url: heroId ? "/HeroApp/api/hero/" + heroId : "/HeroApp/api/hero",
        type: 'POST',
        data: JSON.stringify({
            name,
            race,
            profession: {
                id: professionId
            },
            heroIcon
        }),
        contentType: 'application/json',
    }).done(() => {
        heroSubmit.prop('disabled', false);
        window.location.href = '/HeroApp/heroes.jsp';
    }).fail((e) => {
        heroSubmit.prop('disabled', false);
        const errors = e.responseJSON;
        if (errors && Object.keys(errors).length) {
            Object.entries(errors).forEach((error) => {
                $("#" + error[0] + "Error").html(error[1]);
                $("#" + error[0]).toggleClass("is-invalid");
            })
        }
    });
}

function getHeroId() {
    const urlParams = new URLSearchParams(window.location.search);
    const heroId = urlParams.get('hero_id');
    return heroId || false;
}

function submitProfessionAjax(name, hp, mana) {
    const professionSubmit = $('#professionSubmit');
    professionSubmit.prop('disabled', true);
    $.ajax({
        url: "/HeroApp/api/profession",
        type: 'POST',
        data: JSON.stringify({
            name,
            hp,
            mana
        }),
        contentType: 'application/json',
    }).done((data) => {
        professionSubmit.prop('disabled', false);
        $('#professionModal').modal('hide');
        getProfessions(data);

    }).fail((e) => {
        professionSubmit.prop('disabled', false);
        const errors = e.responseJSON;
        if (errors && Object.keys(errors).length) {
            if (errors.name){
                $("#professionNameError").html(errors.name);
                $("#professionName").toggleClass("is-invalid");
            }
            if (errors.hp){
                $("#professionHpError").html(errors.hp);
                $("#professionHp").toggleClass("is-invalid");
            }
            if (errors.mana){
                $("#professionManaError").html(errors.mana);
                $("#professionMana").toggleClass("is-invalid");
            }
            if (errors.Hp_Mana){
                if (!errors.hp && !errors.mana) {
                    $("#professionHpError").html(errors.Hp_Mana);
                    $("#professionHp").toggleClass("is-invalid");
                    $("#professionManaError").html(errors.Hp_Mana);
                    $("#professionMana").toggleClass("is-invalid");
                }
                
            }
            
            
        }
    });
}

function sendProfessionForm() {
    const professionName = $('#professionName').val();
    const professionHp = $('#professionHp').val();
    const professionMana = $('#professionMana').val();
    $(".has-validation").removeClass("is-invalid");

    submitProfessionAjax(professionName, professionHp, professionMana);
}

function changeHp(){
    const professionManaElement = $('#professionMana');
    const professionHp = $('#professionHp').val();
    professionManaElement.val(100 - professionHp);
    $('#professionHpValue').html(professionHp);
    $('#professionManaValue').html(professionManaElement.val());
}

function changeMana(){
    const professionHpElement = $('#professionHp');
    const professionMana = $('#professionMana').val();
    professionHpElement.val(100 - professionMana);
    $('#professionManaValue').html(professionMana);
    $('#professionHpValue').html(professionHpElement.val());
}

function previewFile() {
    const icon = $('#heroIcon')[0].files[0];
    if (icon) {
        $('#heroIconLabel').html(icon.name);
        const reader = new FileReader();
        reader.readAsDataURL(icon);
        reader.onloadend = () => {
            const heroIcon = reader.result;
            $('#heroImage').attr('src', heroIcon).show();
        }
    } else {
        $('#heroImage').hide();
        $('#heroIconLabel').html("Choose File");
    }
}