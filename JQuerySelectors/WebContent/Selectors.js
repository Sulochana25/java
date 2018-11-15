$(document).ready(function(){
	//Change all 'p' tags to blue color
	$("p").css("color","blue");
	
	//change all tags with class div1 to red color
	$(".div1").css("color","red");

	//Hide elements with span tag
	$("span").hide();
	
	//show elements using show tag
	$("span").show();
	
	//select multiple elements to apply style
	$("p,b,span").css("background-color","yellow");

	//Select the first occurrence of a selector
	$("p:first").css("background-color","black");
	
	//Select the last occurrence of a selector
	$("p:last").css({"padding":"5px","text-decoration":"underline"});
	
	//Select nth child of a selector
	$("div:nth-child(2)").show();
	
	//Select all selector elements that is direct child of a specified selector
	$("div > p").css({"padding":"20px","text-decoration":"overline"});
	
	//All elements that are siblings of a specified selector
	$("p ~ b").css({"padding":"10px","text-decoration":"line-through"});
	
	//Select all elements that contain certain word in text
	$("p:contains('This')").css({"color":"green","text-decoration":"none"});
	
	//Select all elements which contains certain word in an attribute
	$("[id~='p1']").css({"color":"white","text-decoration":"none"});
	
	//select attribute starting with some value
	$("[id^='p1']").css({"background-color":"red"});
	
	//select elements standing at certain position
	$("td:eq(1)").css({"background-color":"red"});
	$("td:eq(6)").css({"background-color":"red"});
	
	//Select all elemenrts with empty text
	$(":empty").css({"background-color":"yellow"});
	
	//select all elements whose position is greater than certain number
	$("td:gt(3)").css({"background-color":"coral"});
	
	//All elements with no certain attribute or no attribute at all
	$("p[id!='p1 p']").css({"background-color":"coral"});
	
	//Select All even indexed elements
	$("tr:even").hide();
	
	$("tr:even").show();
});