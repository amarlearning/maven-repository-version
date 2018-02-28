(function() {

	'use strict';

	var editor = ace.edit("editor");

	editor.setShowPrintMargin(false);
	editor.setTheme("ace/theme/monokai");
	editor.session.setMode("ace/mode/xml");

	$("#submit").click(function(){
		$.ajax({
			url : "/submitXML",
			type : "POST",
			data : editor.getValue(),
			contentType : "application/xml; charset=utf-8",
			dataType : "xml",
			success : function(data) {
				editor.setValue("Hello World", -1)
			}
		});
	});

})(); 