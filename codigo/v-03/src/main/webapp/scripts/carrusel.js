/**
 * AdminGol Dic/2014
 */

var idActual = 1;
var maxSize;

dojo.addOnLoad(function(){
	dojo.connect(dojo.byId("next"), "click", next);	
	dojo.connect(dojo.byId("back"), "click", back);
	maxSize = dojo.byId("carrusel_wrapper").children.length;
});

function next(){
	var divActual;
	divActual = dojo.byId("item" + idActual);
	dojo.removeClass(divActual, "actual");
	dojo.addClass(divActual, "oculto");
	idActual = (idActual + 1 > maxSize) ? 1 : ++idActual;
	divActual = dojo.byId("item" + idActual);
	dojo.addClass(divActual, "actual");
	dojo.removeClass(divActual, "oculto");
}

function back(){
	var divActual;
	divActual = dojo.byId("item" + idActual);
	dojo.removeClass(divActual, "actual");
	dojo.addClass(divActual, "oculto");
	idActual = (idActual - 1 == 0) ? maxSize : --idActual;   
	divActual = dojo.byId("item" + idActual);
	dojo.addClass(divActual, "actual");
	dojo.removeClass(divActual, "oculto");
}
