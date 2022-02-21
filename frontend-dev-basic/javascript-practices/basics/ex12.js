/*
    Array 확장 (prototype 기반의 확장) : List 메소드 추가
*/

Array.prototype.remove = function(index) {
    this.splice(index, 1);
}

Array.prototype.insert = function(index, value) {
    if (value instanceof Array) {
        // for (var i = 0; i < value.length; ++i) {
        //     this.splice(index + i, 0, value[i]);
        // }

        // 오류 !! : callback 안의 this는 Array가 아닐 가능성이 있음 (어휘상의 this와 일치하지 않는다.)
        // value.forEach(function(e) {
        //     this.splice(index++, 0, e);
        // })

        // 해결 방법 1 : this를 변수로 지정하여 사용
        // var _this = this;
        // value.forEach(function(e) {
        //     _this.splice(index++, 0, e);
        // })

        // 해결 방법 2 : 함수의 bind로 함수 실행 때의 this를 세팅
        value.forEach(function(e) {
            this.splice(index++, 0, e);
        }.bind(this));

    } else {
        this.splice(index, 0, value);
    }
}

// List로 사용하기
var a = [1, 2, 4];
console.log(a);

a.insert(2, 3);
console.log(a);

a.remove(3);
console.log(a);

a.insert(2, ['a', 'b', 'c']); // 기대 [1, 2, 'a', 'b', 'c', 3]
console.log(a);