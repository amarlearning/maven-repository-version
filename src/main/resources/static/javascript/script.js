(function() {

	'use strict';

	var editor = ace.edit("editor");

	editor.setShowPrintMargin(false);
	editor.setTheme("ace/theme/monokai");
	editor.session.setMode("ace/mode/xml");
	
	$("#submitXML").submit(function() {
		$("input[name=xmlData]").val(editor.getValue());
	});

})();