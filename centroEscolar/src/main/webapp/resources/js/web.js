
//Llamamos al funcion que comprueba el nagedaor al cargarse la página
window.onload = comprobarnavegador();

function comprobarnavegador() {
    /* Variables para cada navegador, la funcion indexof() si no encuentra la cadena devuelve -1, 
    las variables se quedaran sin valor si la funcion indexof() no ha encontrado la cadena. */
    var is_safari = navigator.userAgent.toLowerCase().indexOf('safari/') > -1;
    var is_chrome= navigator.userAgent.toLowerCase().indexOf('chrome/') > -1;
    var is_firefox = navigator.userAgent.toLowerCase().indexOf('firefox/') > -1;
    var is_ie = navigator.userAgent.toLowerCase().indexOf('msie ') > -1;

    //Detectando si es IE, Safari
    if (is_ie || is_safari) {
        
    	alert("Web optimizada para Chrome y Firefox");
    }
}

// Funcion para mostrar el div con los datos del desarrollador
function desarrollador(event){
	// Determina la posici�n del div respecto el raton
	margin = 5;
	
	//La variable IE determina si estamos utilizando IE
	var IE = document.all?true:false;
	
	//Si no utilizamos IE capturamos el evento del mouse
	if (!IE) document.captureEvents(Event.MOUSEMOVE);

	var tempX = 0;
	var tempY = 0;

	if(IE)
	{ //para IE
		tempX = event.clientX + document.body.scrollLeft;
		tempY = event.clientY + document.body.scrollTop;
	}else{ //para netscape
		tempX = event.pageX;
		tempY = event.pageY;
	}
	if (tempX < 0){tempX = 0;}
	if (tempY < 0){tempY = 0;}

	var top = tempY+margin;
	var left = tempX+margin;
	
	document.getElementById('desarrollador').style.top = top +'px';
	document.getElementById('desarrollador').style.left = left + 'px';
	document.getElementById('desarrollador').style.display='block';
	return;
}