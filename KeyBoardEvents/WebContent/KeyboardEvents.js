$(document).ready(function(){
	$(":input").keypress(function(){
		$("p").append("<strong>KeyPress event occurred<br>");
	});
	
	$(":input").keydown(function(){
		$("p").append("<strong>KeyDown event occurred<br>");
	});
	
	$(":input").keyup(function(){
		$("p").append("<strong>KeyUp event occurred<br>");
	});
});

