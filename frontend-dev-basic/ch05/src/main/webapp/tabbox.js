// DOM Event Model Level 0 : Basic
// JavaScript code (DOM API)로 만 작성
var TabBox = {

    init: function() {
        window.addEventListener('load', this._onWindowLoaded.bind(this));
    },

    _onWindowLoaded: function() {

        console.log(this);
        console.log("dom loaded!");
        var divTabBox = document.getElementsByClassName('tab-box')[0];
        var ul = divTabBox.childNodes[1];

        var liTabs = ul.getElementsByTagName('li');

        for (var i = 0; i < liTabs.length; i++) {
            liTabs[i].addEventListener('click', this._onTabClicked);
        }
    },

    _onTabClicked: function() {
        console.log(this);
        // unselect
        var liSelected = document.getElementsByClassName('selected');

        (liSelected.length === 1) && (liSelected[0].className = "");

        // select
        this.className = 'selected';
    }

}