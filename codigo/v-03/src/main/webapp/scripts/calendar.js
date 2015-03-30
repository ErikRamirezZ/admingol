/**
 * 
 */

var MONTHLY = 'MONTHLY';
var WEEKLY = 'WEEKLY';
var DAILY = 'DAILY';


var currentDate;
var frequency = MONTHLY;

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

/**
 * Realiza las operaciones necesarias para obtener el periodo siguiente en base a la 
 * <b>fequency</b> y a la <b>currenDate</b>
 */
function next() {
	if(frequency == MONTHLY) {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, currentDate.getDate());
		monthly();
	} else if(frequency == WEEKLY) {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()+7);
		weekly();		
	} else if(frequency == DAILY) {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, currentDate.getDate()+1);
//		weekly();
	} 
}


/**
 * Realiza las operaciones necesarias para obtener el periodo anterior en base a la 
 * <b>fequency</b> y a la <b>currenDate</b>
 */
function back() {
	if(frequency == MONTHLY) {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()-1, currentDate.getDate());
		monthly();
	} else if(frequency == WEEKLY) {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()-7);
		weekly();		
	} else if(frequency == DAILY) {
		currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth()+1, currentDate.getDate()-1);
//		weekly();
	} 
}


/**
 * Llamada JSON para obtener los partidos por el tipo de calendario y la 
 * fecha que se esta manejando
 */
function jsonCallFindPartidosByFechaBetween(frequency, currentDate) {
	dojo.xhrGet({
	    url: "/admingol/partidoes/findPartidoesByFechaAndFrequency",
	    handleAs: "json",
	    preventCache: true,
	    load: function(data, ioargs){
	      targetNode.innerHTML = "XHR returned HTTP status: " + ioargs.xhr.status;
	    },
	    error: function(error, ioargs){
	      var message = "";
	      switch(ioargs.xhr.status){
	         case 404:
	           message = "The requested page was not found";
	           break;
	         case 500:
	           message = "The server reported an error.";
	           break;
	         case 407:
	           message = "You need to authenticate with a proxy.";
	           break;
	         default:
	           message = "Unknown error.";
	      }
	      targetNode.innerHTML = message;
	    }
	  });
}


