/*
    URL 다루기
*/

var url1 = "http://www.mysite.com/user?name=둘리&no=10";

// 1. escape : URL 전부 encoding, 사용 x (deprecated)
var url2 = escape(url1);
console.log(url2);

// 2. encodeURI : parameter 만 encoding
var url3 = encodeURI(url1);
console.log(url3);

// 3. encodeURIComponent : 값만 encoding 해야하는 경우
var url4 = encodeURIComponent(url1); // 잘못 사용한 경우
console.log(url4);

// 4. 
// 만들어야 할 URL
// http://mysite.com/user?no=10&name=둘리&email=dooly@gmail.com

var url = "http://mysite.com/user"
var param = {
    name: "둘리",
    eamil: "dooly@gmail.com",
    no: 10
};

var toQueryString = function(o) {
    var qs = [];
    for (prop in o) {
        qs.push(prop + "=" + encodeURIComponent(o[prop]));
    }
    return qs.join('&');
}

var url5 = url + "?" + toQueryString(param);
console.log(url5);
console.log(decodeURIComponent(url5));



/*
    jQuery = function() { ... }
    $ = jQuery;

    jQuery.ajax
    $.ajax({
        url: url,
        type: 'post',
        dataType: toQueryString(o)
        ...
    })

*/