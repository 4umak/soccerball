$('.owl-carousel').owlCarousel({
    margin:0,
    loop:false,
    dots:false,
    nav: true,
    items:4,
    AutoHeight: true,
    autoWidth:false,
    navText : ['<i class="fa fa-angle-left" aria-hidden="true"></i>','<i class="fa fa-angle-right" aria-hidden="true"></i>']

});
function add_news_list_items(title) {
    $("#news-list-items").append(' <div class="news-list-one-items">\n' +
        '        <a class="news-list-one-items-title">\n' +
        '           '+title+'\n' +
        '        </a>\n' +
        '    </div>')
}
function add_carousel_items(legue,t1,t2) {


    $("#items-carousel").trigger('add.owl.carousel', ['<div class="header-match-one-item">\n' +
    '    <div class="header-tournament-name">\n' +
    '        ⚽ ' + legue+
    '    </div>\n' +
    '    <div class="header-fst-team-name">\n' +
    '        ' + t1+
    '    </div>\n' +
    '    <div class="header-snd-team-name">\n' +
    '       ' + t2+
    '    </div>\n' +
    '</div>'])
        .trigger('refresh.owl.carousel');
}
function add_hot_news_items(img,title,content) {

    $("#hot-news-items").append('<div class="hot-news-one-item">\n' +
        '    <img src="'+img+'" alt="hot_img">\n' +
        '    <div class="hot-news-one-item-title">'+title+'</div>\n' +
        '    <div class="hot-news-one-item-content"> ' + content +
        ' <button class="news-button">More</button>\n' +
        '</div>')
}

var request = new XMLHttpRequest();
request.open('GET', 'http://localhost:8083/api/countries', true);
request.onload = function() {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response);
    data.forEach(country => {
        add_carousel_items(country.country_name,'Ukraine','Bowaria')
})
}

request.send()


add_hot_news_items('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')
add_hot_news_items('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')
add_hot_news_items('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')
add_hot_news_items('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')
add_hot_news_items('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')
add_hot_news_items('img/testimage.jpg','Ukraine','That\'s it. If it can be multiple lines, then it is somewhat more complicated. But there are solutions on http://pmob.co.uk/ Look for "vertical align".\n' +
    '\n' +
    '        Since they tend to be hacks or adding complicated divs... I usually use a table with a single cell to do it... to make it as simple as possible.')
add_news_list_items("Woaw")
add_news_list_items("Test")
add_news_list_items("Test")
add_news_list_items("123")
add_news_list_items("asdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
add_news_list_items("Woaw")
add_news_list_items("asdsafas")
add_news_list_items("afsfasd")
add_news_list_items("Woasfasfsadaw")