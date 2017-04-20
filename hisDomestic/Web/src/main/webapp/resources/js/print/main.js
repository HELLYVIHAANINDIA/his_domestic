$(document).ready(function() {
    $(".ui-state-default").hover(function() {
        fadeAndChange(this, true);
    },
		function() {
		    fadeAndChange(this, false);
		})
		.mousedown(function(){ setActive(this,true);})
		.mouseup(function(){setActive(this,false);})
		.mouseout(function(){setActive(this,false);})
		.focus(function(){ setFocus(this, true);})
		.blur(function() { setFocus(this, false); setSelected(this, false);})
		.select(function(){ setSelected(this, true);})
		.fadeTo('fast', 0.8);
    //Separate things that load scripts..
    $(".accordionme").accordion({collapsible: true, active:false});
    setTimeout(function() {
        var user = "erikzaadi";
        $('#switcher').themeswitcher();
          InitTwitter(user);		  
    }, 25);

});

function setSelected($elem, toggle){
    $($elem).toggleClass("ui-state-highlight", toggle);
}

function setFocus($elem, toggle){
    $($elem).toggleClass("ui-state-focus", toggle);
}

function setActive($elem, toggle){
    $($elem).toggleClass("ui-state-active", toggle);
}

function fadeAndChange($elem, toggle) {
    $($elem).stop().toggleClass("ui-state-hover", toggle).fadeTo('slow', toggle ? 1.0 : 0.8);
}