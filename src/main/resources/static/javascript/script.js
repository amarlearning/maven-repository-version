(function() {
	
	'use strict';
	
	var editor = ace.edit("editor");
	
	editor.setShowPrintMargin(false);
	editor.setTheme("ace/theme/monokai");
	editor.session.setMode("ace/mode/xml");
	
	$("#generatepom").click(function() {
		console.log("Ace editor value : " + editor.getValue());
	});
	
})();