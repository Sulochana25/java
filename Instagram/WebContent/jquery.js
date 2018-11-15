$(document).ready(function(){
	$("a").click(function(e) {
        e.preventDefault();
        
        $("#frame1").attr("src", $(this).attr("href"));
    })
    
   
    function imagePreview(input) 
    {
      if (input.files && input.files[0]) 
      {
        var filerdr = new FileReader();
        filerdr.onload = function(e) {
            $('.displayPhoto').attr('src', e.target.result);
        };
        filerdr.readAsDataURL(input.files[0]);
      }
    }

});
