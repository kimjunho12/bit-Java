module.exports = {
    PI: 3.14,
    max: function() {
        var max = Number.MIN_SAFE_INTEGER;
        Array.from(arguments).forEach(function(e) {
            max = e > max ? e : max;
        });

        return max;
    },
    min: function() {
        var min = Number.MAX_SAFE_INTEGER;
        Array.from(arguments).forEach(function(e) {
            min = e < min ? e : min;
        });

        return min;
    }

}