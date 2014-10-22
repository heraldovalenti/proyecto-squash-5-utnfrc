$(function() {
	var buttons = {
		previous : $('#jslidernews2 .button-previous'),
		next : $('#jslidernews2 .button-next')
	};
	$('#jslidernews2').lofJSidernews({
		interval : 5000,
		easing : 'easeInOutQuad',
		duration : 1200,
		auto : true,
		mainWidth : 675,
		mainHeight : 300,
		navigatorHeight : 100,
		navigatorWidth : 310,
		maxItemDisplay : 3,
		buttons : buttons
	});
});