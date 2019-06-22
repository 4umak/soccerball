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
var topMenu = $('#header-menu').offset().top;       // get initial position of the element
var element = document.getElementById('header-menu');
var positionInfo = element.getBoundingClientRect();
var height = positionInfo.height;
var width = positionInfo.width;
console.log(height)
$(window).scroll(function () {                  // assign scroll event listener

    var currentScroll = $(window).scrollTop(); // get current position

    if (currentScroll >= topMenu) {           // apply position: fixed if you
        $('#header-menu').css({                      // scroll to that element or below it
            position: 'fixed',
            width: '100%',
            top: '0',
            height: height
        });
    } else {                                   // apply position: static
        $('#header-menu').css({                      // if you scroll above it
            position: 'static'
        });
    }

});

function add_news_list_item(title) {
    $("#news-list-item").append(' <div class="news-list-one-item">\n' +
        '        <a class="news-list-one-item-title">\n' +
        '           ' + title + '\n' +
        '        </a>\n' +
        '    </div>')
}

function add_news_list_items(title, id) {
    $("#news-list-items").append(' <div class="news-list-one-items" >\n' +
        '        <a class="news-list-one-items-title" id = "' + id + '"  onclick="showArticle(this.href, this.id)">\n' +
        '           ' + title + '\n' +
        '        </a>\n' +
        '    </div>')
}

function showArticle(href, id) {
    window.location = href + 'news_detail.html?newsId=' + id;
}

function add_carousel_items(id, t1, t2, time) {

    $("#footer").load("include/footer.html");
    $("#items-carousel").trigger('add.owl.carousel', [' <div class="header-match-one-item">\n' +
    '                        <div class="header-match-one-item-desc">\n' +
    '<div></div>' +
    '                            <div id="time_{{id}}" class="header-tournament-name">\n' +
    '                                ⚽ \n' + time +
    '                            </div>\n' +
    '                            <div class="header-fst-team-name">\n' +
    '                                \n' + t1 +
    '                            </div>\n' +
    '                            <div class="header-snd-team-name">\n' +
    '                                \n' + t2 +
    '                            </div>\n' +
    '                        </div>\n' +
    '                        <div class="header-match-one-item-links">\n' +
    '                            <a href="../frontend/match_details.html" onclick="location.href=this.href+\'?matchId=\'+ document.getElementById(\'match-id\').innerText;return false;">МАТЧ</a>\n' +
    '                        </div>\n' +
    '                    </div>'])
        .trigger('refresh.owl.carousel');
    $(function () {


        $("#footer").load("include/footer.html");
        $('.header-match-one-item').hover(function () {

            console.log(1)
            $(this).find('.header-match-one-item-desc').hide();
            $(this).find('.header-match-one-item-links').show();
        }, function () {
            $(this).find('.header-match-one-item-links').hide();
            $(this).find('.header-match-one-item-desc').show();
        });
    });
}

function add_hot_news_items(img, title, content) {

    $("#hot-news-items").append('<div class="hot-news-one-item">\n' +
        '    <img src="' + img + '" alt="hot_img">\n' +
        '    <div class="hot-news-one-item-title">' + title + '</div>\n' +
        '    <div class="hot-news-one-item-content"> ' + content +
        ' <a class="news-button">More</a>\n' +
        '</div>')
}

function add_hot_news_item(img, title, content) {

    $("#hot-news-item").append('<div class="hot-news-one-item1">\n' +
        '    <img src="' + img + '" alt="hot_img">\n' +
        '    <div class="hot-news-one-item-title1">' + title + '</div>\n' +
        '    <div class="hot-news-one-item-content1"> ' + content +
        '</div>')
}

function fillNews() {
    let request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8083/articles', true);
    request.onload = function () {
        let data = JSON.parse(this.response);
        for (let i = 0; i < data.content.length; i++) {
            add_news_list_items(data.content[i].name, data.content[i].id);
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
                add_carousel_items(match.match_id, match.match_hometeam_name, match.match_awayteam_name, match.match_time);
        });
    };
    request.send();
}

function fillNewsDetailsPageByNewsId(id) {
    let request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8083/articles/' + id, true);
    request.onload = function () {
        // Begin accessing JSON data here
        let data = JSON.parse(this.response);
        add_hot_news_item(data.image_link, data.name, data.content)
    };
    request.send();
}

//рендерим матч
function add_full_match(title, imgT1, imgT2, scoreT1, scoreT2, T1, T2, date) {
    $("#mathc-news-items").append('<div class="match-news-one-item">\n' +
        '    <div class="match-news-title"><h1>' + title + '</h1></div>\n' +
        '    <div class="team-imgs">\n' +
        '        <img class="img-team1" src="' + imgT1 + '" alt="test" height="200" width="300">\n' +
        '        <div class="match-news-score-box">\n' +
        '            <div class="match-news-score" id="match-news-team1-score">' + scoreT1 + '</div>\n' +
        '            <div class="match-news-score">:</div>\n' +
        '            <div class="match-news-score" id="match-news-team2-score">' + scoreT2 + '</div>\n' +
        '        </div>\n' +
        '\n' +
        '        <img class="img-team2" src="' + imgT2 + '" alt="test" height="200" width="300">\n' +
        '    </div>\n' +
        '\n' +
        '    <div id="just-opacity-team1" class="just-opacity">\n' +
        '        <img  src="' + imgT1 + ' alt="test" height="200" width="300">\n' +
        '    </div>\n' +
        '    <div id="just-opacity-team2" class="just-opacity">\n' +
        '        <img  src="' + imgT2 + '" alt="test" height="200" width="300">\n' +
        '    </div>\n' +
        '\n' +
        '\n' +
        '    <div class="teams">\n' +
        '        <div class="match-news-teams" id="match-news-team1">' + T1 + '</div>\n' +
        '\n' +
        '        <div class="match-news-teams" id="match-news-team2">' + T2 + '</div>\n' +
        '    </div>\n' +
        '    <div class="match-news-date">' + date + '</div>\n' +
        '    <div  class="live">\n' +
        '        <iframe\n' +
        '                src="https://player.twitch.tv/?channel=dallas&muted=true"\n' +
        '                height="310"\n' +
        '                width="640"\n' +
        '                frameborder="0"\n' +
        '                scrolling="no"\n' +
        '                allowfullscreen="true">\n' +
        '        </iframe>\n' +
        '    </div>\n' +
        '</div>')
}

//коментарь
function add_comments(username, content) {
    $("#coments-items").append(' <div class="coment-one-item">\n' +
        '    <div class="username">' + username + '</div>\n' +
        '    <hr>\n' +
        '    <div class="comments-content">' + content + '</div>\n' +
        '    </div>')
}

fillMatches();
fillNews();
fillNewsDetailsPageByNewsId(window.location.search.split('=')[1]);
//для одної новості
// add_hot_news_item('img/testimage.jpg', 'Ukraine', 'That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
//     '\n' +
//     '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.' +
//     '\n' + '\n' +
//     '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.' +
//     '\n' + '\n' +
//     '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.' +
//     '\n' + '\n' +
//     '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.' +
//     '\n' + '\n' +
//     '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')

//match_detail

add_full_match("TITLE/DATE", "img/team1.jpg", "img/team2.jpg", "0", "0", "Ukraine", "Russia", "20.06.2019")

//addcoments

add_comments('Flo', 'Hi')
add_comments('Flo', 'Test')
add_news_list_item("Woaw")
add_news_list_item("Test")
add_news_list_item("Test")
add_news_list_item("123")
add_news_list_item("asdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
add_news_list_item("Woaw")
add_news_list_item("asdsafas")
add_news_list_item("afsfasd")
add_news_list_item("Woasfasfsadaw")

