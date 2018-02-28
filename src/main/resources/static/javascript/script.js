(function() {

	'use strict';

	var editor = ace.edit("editor");

	editor.setShowPrintMargin(false);
	editor.setTheme("ace/theme/monokai");
	editor.session.setMode("ace/mode/xml");

	/*$("#submitXML").submit(function() {

		var xmlText = new XMLSerializer().serializeToString(editor.getValue());

		$("input[name=xmlData]").val(xmlText);
		alert($("input[name=xmlData]").val());
		console.log($("input[name=xmlData]").val());
	});*/

	$("#submitXML").submit(function() {
		alert("new y");
		$.post("/submitXML", {
			'data' : editor.getValue()
		}, function(data) {
			console.log("Data is : " + data);
		});
	});

})();