(function() {

	'use strict';

	var editor = ace.edit("editor");

	editor.setShowPrintMargin(false);
	editor.setTheme("ace/theme/monokai");
	editor.session.setMode("ace/mode/xml");

	$(".error-hide").hide();
	$(".success-hide").hide();
	
	$("#submit").click(function(){
		$.ajax({
			url : "/submitXML",
			type : "POST",
			data : editor.getValue(),
			contentType : "application/xml; charset=utf-8",
			dataType : "xml",
			success : function(data) {
				$(".success-hide").show();
				editor.setValue(new XMLSerializer().serializeToString(data));
			},
			error: function (error) {
				$(".error-hide").show();
			}
		});
	});

})(); 