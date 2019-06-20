$('.owl-carousel').owlCarousel({
    margin: 0,
    loop: false,
    dots: false,
    nav: true,
    items: 4,
    AutoHeight: true,
    autoWidth: false,
    navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i>', '<i class="fa fa-angle-right" aria-hidden="true"></i>']

});

function add_news_list_items(title, id) {
    $("#news-list-items").append(' <div class="news-list-one-items">\n' +
        '        <a class="news-list-one-items-title">\n' +
        '           ' + title + '\n' +
        '        </a>\n' +
        '    </div>')
}

function add_carousel_items(t1, t2, time) {


    $("#items-carousel").trigger('add.owl.carousel', ['<div class="header-match-one-item">\n' +
    '    <div class="header-tournament-name">\n' +
    '        ⚽ ' + time +
    '    </div>\n' +
    '    <div class="header-fst-team-name">\n' +
    '        ' + t1 +
    '    </div>\n' +
    '    <div class="header-snd-team-name">\n' +
    '       ' + t2 +
    '    </div>\n' +
    '</div>'])
        .trigger('refresh.owl.carousel');
}

function add_hot_news_items(img, title, content) {

    $("#hot-news-items").append('<div class="hot-news-one-item">\n' +
        '    <img src="' + img + '" alt="hot_img">\n' +
        '    <div class="hot-news-one-item-title">' + title + '</div>\n' +
        '    <div class="hot-news-one-item-content"> ' + content +
        ' <button class="news-button">More</button>\n' +
        '</div>')
}
function add_hot_news_item(img,title,content) {

    $("#hot-news-item").append('<div class="hot-news-one-item1">\n' +
        '    <img src="'+img+'" alt="hot_img">\n' +
        '    <div class="hot-news-one-item-title1">'+title+'</div>\n' +
        '    <div class="hot-news-one-item-content1"> ' + content +
        '</div>')
}

function fillNews() {
    let request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8083/articles', true);
    request.onload = function () {
        let data = JSON.parse(this.response);
        for (let i = 0; i < data.content.length; i++) {
            add_news_list_items(data.content[i].name);
            add_hot_news_items(data.content[i].image_link, data.content[i].name, data.content[i].content)
        }
    };
    request.send();
}

function fillMatches() {
    let interesting_countries = ["41", "68", "135", "51", "46", "100", "13", "115", "151", "120", "168"];
    let request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8083/api/today', true);
    request.onload = function () {
        // Begin accessing JSON data here
        let data = JSON.parse(this.response);
        data.forEach(function (match) {
            if (interesting_countries.includes(match.country_id) && match.match_status !== "Finished")
                add_carousel_items(match.match_hometeam_name, match.match_awayteam_name, match.match_time);
        });
    };
    request.send();
}
add_hot_news_item('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.'+
    '\n' +'\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.'+
    '\n' +'\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.'+
    '\n' +'\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.'+
    '\n' +'\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')

fillMatches();
fillNews();