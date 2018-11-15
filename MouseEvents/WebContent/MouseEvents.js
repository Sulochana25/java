$(document).ready(function(){
	$("p").click(function(){
		$(this).addClass("changeToRed");
	});
	
	$("p").dblclick(function(){
		$(this).addClass("changeToBlue");
	});
	$("p").not("#p1").mouseenter(function(){
		$(this).addClass("changeToCoral");
	});
	$("p[id='p1']").mouseleave(function(){
		$(this).addClass("changeToGreen");
	});
});