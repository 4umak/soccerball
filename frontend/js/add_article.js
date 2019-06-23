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

fillChamps();
fillCountries();