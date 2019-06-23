function add_championship_select(value, name) {
    var select = document.getElementById("champ");
    select.options[select.options.length] = new Option(name, value);

}

function country_select(value, name) {
    var select = document.getElementById("country");
    select.options[select.options.length] = new Option(name, value);

}


function fillCountries() {
    let request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8083/countries', true);
    request.onload = function () {
        // Begin accessing JSON data here
        let data = JSON.parse(this.response);
        for (let i = 0; i < data.content.length; i++) {
            country_select(data.content[i].id, data.content[i].name);
        }
    };
    request.send();
}

function fillChamps() {
    let request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8083/championships', true);
    request.onload = function () {
        // Begin accessing JSON data here
        let data = JSON.parse(this.response);
        for (let i = 0; i < data.content.length; i++) {
            add_championship_select(data.content[i].id, data.content[i].name);
        }
    };
    request.send();
}

function add_article() {
    let image = $('#im').val();
    let date = $('#date').val();
    let country = $('#country').val();
    let champ = $('#champ').val();
    let name = $('#name').val();
    let content = $('#content').val();
    let data = {
        name: name,
        create_date: date,
        content: content,
        image_link: image,
        championship: champ,
        country: country
    };
    let xhr = new XMLHttpRequest();
    $.ajax({
        url: 'http://localhost:8083/articles/add',
        type: 'POST',
        data: JSON.stringify(data),
        datatype: 'json',
        success: function (result) {
            alert(result);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert("prrr" + xhr.status);
            alert(thrownError);
        }
    });

}

fillChamps();
fillCountries();