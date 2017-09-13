// JavaScript Document

		$(document).ready(function(){
			$("#step2").hide();
			$("#step3").hide();
			$("#step4").hide();
			$("#step5").hide();
			
			$("#next1").click(function(){
				$("#step2").fadeIn();
			});
			$("#next2").click(function(){
				$("#step3").fadeIn();
			});
			$("#next3").click(function(){
				$("#step4").fadeIn();
			});
			$("#next4").click(function(){
				$("#step5").fadeIn();
			});
		});

      var input = document.getElementById('autocomplete');
      var autocomplete = new google.maps.places.Autocomplete(input);
