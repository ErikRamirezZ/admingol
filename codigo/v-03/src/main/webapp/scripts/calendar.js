/**
 * 
 */

var currentDate;
var frequency = "monthly";

dojo.addOnLoad(function(){
	  monthly();
//	  weekly();
});


var headerTable = "<thead><tr><th>Lunes</th><th>Martes</th><th>Miercoles</th><th>Jueves</th><th>Viernes</th><th>Sabado</th><th>Domingo</th></tr></thead>";
var bodyTable = "";
function monthly() {
	if(currentDate == null) {
		currentDate = new Date();
	}
	var firstDay = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);
	var lastDay = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);

	var fd = firstDay.getUTCDay();

	bodyTable = "<tr>";
  if(fd > 1 ) {
    for(var i = fd-1; i > 0; i--){
      var x = new Date(currentDate.getFullYear(), currentDate.getMonth(), -i);
      bodyTable += "<td><div id='number'>"+x.getDate()+"</div></td>";
    }	
  } else if(fd == 0) {
    for(var i = 5; i >= 0; i--){
      var x = new Date(currentDate.getFullYear(), currentDate.getMonth(), -i);
      bodyTable += "<td><div id='number'>"+x.getDate()+"</div></td>";
    }		  
  } 
  var dateTemp = null;
  for(var i = 1; i <= lastDay.getDate(); i++){
    dateTemp = new Date(currentDate.getFullYear(), currentDate.getMonth(), i);
    bodyTable += "<td><div id='number'>"+dateTemp.getDate()+"</div></td>";
    if(dateTemp.getUTCDay() == 0){
      bodyTable += "</tr>";
      bodyTable += "<tr>";
    }
  }
  if(dateTemp.getUTCDay() != 0) {
    var dd = 7-dateTemp.getUTCDay();
    for(var i = 1; i <= dd; i++){
      dateTemp = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, i);
      bodyTable += "<td><div id='number'>"+dateTemp.getDate()+"</div></td>";
      if(dateTemp.getUTCDay() == 0){
      }
    }
  } else {
    
  }
  bodyTable += "</tr>";
  dojo.byId("_table_calendar").innerHTML = "<table border='2px'>"+ headerTable + bodyTable + "</table>";
  dojo.byId("_current_date").innerHTML = currentDate.toDateString().substring(4, 7) + " " + currentDate.getFullYear();
}

/**
 * 
 */
function weekly() {
  if(currentDate == null) {
	currentDate = new Date();
  }
  var dayStart = currentDate.getDate();
	if(currentDate.getUTCDay() == 0) {
  	dayStart = dayStart - 6;
	} else {
	  dayStart = dayStart - 1;
	}
	bodyTable = "<tr>";
	for(var i = 0; i < 7; i++){
	  var x = new Date(currentDate.getFullYear(), currentDate.getMonth(), dayStart++);
	  bodyTable += "<td>" + x + "</td>";
	}
	bodyTable += "</tr>";
	dojo.byId("_table_calendar").innerHTML = "<table border='2px'>"+ headerTable + bodyTable + "</table>";	
}

function daily() {
    if(currentDate == null) {
		currentDate = new Date();
	}
    var headerTable = "<thead><tr><th>" + currentDate.toString() + "</th></tr></thead>";
    bodyTable = "<tr><td></td></tr>"
    dojo.byId("_table_calendar").innerHTML = "<table border='2px'>"+ headerTable + bodyTable + "</table>";
}
function next() {
	if(frequency == "monthly") {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, currentDate.getDate());
		monthly();
	} else if(frequency == "weekly") {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()+7);
		weekly();		
	} else if(frequency == "daily") {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, currentDate.getDate()+1);
//		weekly();
	} 
}

function back() {
	if(frequency == "monthly") {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()-1, currentDate.getDate());
		monthly();
	} else if(frequency == "weekly") {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()-7);
		weekly();		
	} else if(frequency == "daily") {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, currentDate.getDate()-1);
//		weekly();
	} 
}


function jsonCallFindPartidosByFechaBetween() {
	
}


