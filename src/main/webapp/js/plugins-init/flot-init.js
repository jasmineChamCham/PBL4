(function($) {
    "use strict"
	/*********** REAL TIME UPDATES **************/

	var data = [], totalPoints = 50;

	function getRandomData() {
		if (data.length > 0)
			data = data.slice(1);
		while (data.length < totalPoints) {
			var prev = data.length > 0 ? data[data.length - 1] : 50,
				y = prev + Math.random() * 10 - 5;
			if (y < 0) {
				y = 0;
			} else if (y > 100) {
				y = 100;
			}
			data.push(y);
		}
		var res = [];
		for (var i = 0; i < data.length; ++i) {
			res.push([i, data[i]])
		}
		return res;
	}


	// Set up the control widget
	var updateInterval = 1000;

	var plot4 = $.plot('#flotRealtime1', [getRandomData()], {
		colors: ['#f21780'],
		series: {
			lines: {
				show: true,
				lineWidth: 1
			},
			shadowSize: 0	// Drawing is faster without shadows
		},
		grid: {
			borderColor: 'transparent',
			borderWidth: 1,
			labelMargin: 5
		},
		xaxis: {
			color: 'transparent',
			font: {
				size: 10,
				color: '#fff'
			}
		},
		yaxis: {
			min: 0,
			max: 100,
			color: 'transparent',
			font: {
				size: 10,
				color: '#fff'
			}
		}
	});

	var plot5 = $.plot('#flotRealtime2', [getRandomData()], {
		colors: ['#2097E8'],
		series: {
			lines: {
				show: true,
				lineWidth: 1
			},
			shadowSize: 0	// Drawing is faster without shadows
		},
		grid: {
			borderColor: 'transparent',
			borderWidth: 1,
			labelMargin: 5
		},
		xaxis: {
			color: 'transparent',
			font: {
				size: 10,
				color: '#fff'
			}
		},
		yaxis: {
			min: 0,
			max: 100,
			color: 'transparent',
			font: {
				size: 10,
				color: '#fff'
			}
		}
	});

	function update_plot4() {
		plot4.setData([getRandomData()]);
		plot4.draw();
		setTimeout(update_plot4, updateInterval);
	}

	function update_plot5() {
		plot5.setData([getRandomData()]);
		plot5.draw();
		setTimeout(update_plot5, updateInterval);
	}

	update_plot4();
	update_plot5();
})(jQuery);