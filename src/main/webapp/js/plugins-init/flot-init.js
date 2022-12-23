(function($) {
    "use strict"


	var newCust = [[0, 2], [1, 3], [2, 6], [3, 5], [4, 7], [5, 8], [6, 10]];
	var retCust = [[0, 1], [1, 2], [2, 5], [3, 3], [4, 5], [5, 6], [6, 9]];

	var plot = $.plot($('#flotLine1'), [
		{
			data: newCust,
			label: 'New Customer',
			color: '#f25521'
		},
		{
			data: retCust,
			label: 'Returning Customer',
			color: '#f9c70a'
		}],
		{
			series: {
				lines: {
					show: true,
					lineWidth: 1
				},
				shadowSize: 0
			},
			points: {
				show: false,
			},
			legend: {
				noColumns: 1,
				position: 'nw'
			},
			grid: {
				hoverable: true,
				clickable: true,
				borderColor: '#ddd',
				borderWidth: 0,
				labelMargin: 5,
				backgroundColor: 'transparent'
			},
			yaxis: {
				min: 0,
				max: 15,
				color: 'transparent',
				font: {
					size: 10,
					color: '#999'
				}
			},
			xaxis: {
				color: 'transparent',
				font: {
					size: 10,
					color: '#999'
				}
			}
		});

	var plot = $.plot($('#flotLine2'), [
		{
			data: newCust,
			label: 'New Customer',
			color: '#f21780'
		},
		{
			data: retCust,
			label: 'Returning Customer',
			color: '#fd712c'
		}],
		{
			series: {
				lines: {
					show: false
				},
				splines: {
					show: true,
					tension: 0.4,
					lineWidth: 1,
					//fill: 0.4
				},
				shadowSize: 0
			},
			points: {
				show: false,
			},
			legend: {
				noColumns: 1,
				position: 'nw'
			},
			grid: {
				hoverable: true,
				clickable: true,
				borderColor: '#ddd',
				borderWidth: 0,
				labelMargin: 5,
				backgroundColor: 'transparent'
			},
			yaxis: {
				min: 0,
				max: 15,
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			},
			xaxis: {
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			}
		});

	var newCust2 = [[0, 10], [1, 7], [2, 8], [3, 9], [4, 6], [5, 5], [6, 7]];
	var retCust2 = [[0, 8], [1, 5], [2, 6], [3, 8], [4, 4], [5, 3], [6, 6]];

	var plot = $.plot($('#flotLine3'), [
		{
			data: newCust2,
			label: 'New Customer',
			color: '#f21780'
		},
		{
			data: retCust2,
			label: 'Returning Customer',
			color: '#fd712c'
		}],
		{
			series: {
				lines: {
					show: true,
					lineWidth: 1
				},
				shadowSize: 0
			},
			points: {
				show: true,
			},
			legend: {
				noColumns: 1,
				position: 'nw'
			},
			grid: {
				hoverable: true,
				clickable: true,
				borderColor: '#ddd',
				borderWidth: 0,
				labelMargin: 5,
				backgroundColor: 'transparent'
			},
			yaxis: {
				min: 0,
				max: 15,
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			},
			xaxis: {
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			}
		});


	var plot = $.plot($('#flotArea1'), [
		{
			data: newCust,
			label: 'New Customer',
			color: '#4400eb'
		},
		{
			data: retCust,
			label: 'Returning Customer',
			color: '#44ecf5'
		}],
		{
			series: {
				lines: {
					show: true,
					lineWidth: 0,
					fill: 0.8
				},
				shadowSize: 0
			},
			points: {
				show: false,
			},
			legend: {
				noColumns: 1,
				position: 'nw'
			},
			grid: {
				hoverable: true,
				clickable: true,
				borderColor: '#ddd',
				borderWidth: 0,
				labelMargin: 5,
				backgroundColor: 'transparent'
			},
			yaxis: {
				min: 0,
				max: 15,
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			},
			xaxis: {
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			}
		});

	var plot = $.plot($('#flotArea2'), [
		{
			data: newCust,
			label: 'New Customer',
			color: '#36b9d8'
		},
		{
			data: retCust,
			label: 'Returning Customer',
			color: '#4bffa2'
		}],
		{
			series: {
				lines: {
					show: false
				},
				splines: {
					show: true,
					tension: 0.4,
					lineWidth: 0,
					fill: 0.8
				},
				shadowSize: 0
			},
			points: {
				show: false,
			},
			legend: {
				noColumns: 1,
				position: 'nw'
			},
			grid: {
				hoverable: true,
				clickable: true,
				borderColor: '#ddd',
				borderWidth: 0,
				labelMargin: 5,
				backgroundColor: 'transparent'
			},
			yaxis: {
				min: 0,
				max: 15,
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			},
			xaxis: {
				color: 'transparent',
				font: {
					size: 10,
					color: '#fff'
				}
			}
		});

	var previousPoint = null;

})(jQuery);