$(function() {
    $( 'li').hover(function(){
    	$(this).find('ul.menu>li').stop(true,true).fadeToggle(400);
    });
  });
