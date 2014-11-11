$( document ).ready( function() {
	$(".select-all").click( function() {
		var node = $(".selectable")[0];
		var allSelectables = $(".selectable");
		var checked = (node && node.checked);
		for (var i = 0; i < allSelectables.length; i++) {
			node = allSelectables[i];
			node.checked = !checked;
		}
	});
});