/**
 *  1. 이미지에 click을 했을 때도 이미지가 랜덤하게 바뀌게 끔...
 *  2. 슬라이드 쇼
 *      - 버튼이 '슬라이드쇼 중지'로 바뀌기
 *      - 3초 간격으로 이미지가 랜덤하게 바뀌게 끔
 *      - 버튼을 누르면 슬라이드 쇼 중지
 *      - 버튼을 '슬라이드쇼 시작'으로 바뀌기
 *  3. imageViewer object로 객체화 캡슐화 시키기
 */

var imageViewer = {
    init: function() {
        console.log(this);
        $(() => {
            console.log(this);
            this._imageChange();
            $("#btn-change, .image-viewer img").click(this._imageChange.bind(this));
            $("#btn-slideshow").click(this._onClickedSlideShow.bind(this));
        })
    },

    _images: [{
        name: "국화",
        file: "Chrysanthemum.jpg"
    }, {
        name: "사막",
        file: "Desert.jpg"
    }, {
        name: "수국",
        file: "Hydrangeas.jpg"
    }, {
        name: "해파리",
        file: "Jellyfish.jpg"
    }, {
        name: "코알라",
        file: "Koala.jpg"
    }, {
        name: "등대",
        file: "Lighthouse.jpg"
    }, {
        name: "펭귄",
        file: "Penguins.jpg"
    }, {
        name: "툴립",
        file: "Tulips.jpg"
    }],


    _imageChange: function() {
        var index = Math.floor(Math.random() * this._images.length);
        $(".image-viewer img").attr({
            alt: this._images[index].name,
            src: 'images/' + this._images[index].file
        })
    },

    _slide: null,
    _isSliding: false,
    _onClickedSlideShow: function() {
        console.log(this);
        this._isSliding = !this._isSliding;
        if (this._isSliding) {
            $("#btn-slideshow").text("슬라이드쇼 중지");
            _slide = setInterval(this._imageChange.bind(this), 3000);
        } else {
            $("#btn-slideshow").text("슬라이드쇼 시작");
            clearInterval(_slide)
        }
    }

}