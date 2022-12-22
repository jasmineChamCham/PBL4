(function($) {
    "use strict"

    
    Morris.Donut({
        element: 'morris_donught',
        data: [{
            label: "\xa0 \xa0 Available \xa0 \xa0",
            value: 3,

        }, {
            label: "\xa0 \xa0 Not available \xa0 \xa0",
            value: 2
        }, {
            label: "\xa0 \xa0 Unknown \xa0 \xa0",
            value: 1
        }],
        resize: true,
        colors: ['rgb(112, 226, 145)', 'rgb(254, 102, 102)', 'rgb(197, 197, 197)']
    });
})(jQuery);