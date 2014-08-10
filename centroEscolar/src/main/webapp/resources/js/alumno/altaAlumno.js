var identificador = false;

function enviarFormulario(){
	
	comprovarCampos();
	
	if(identificador){
		return true;
	}
	else{
		alert("Falta algun campo por rellenar");
		return false;
	}
	
}

function borrarFormulario(){
	
	document.getElementById("identificador").value='';
}


function comprovarCampos(){
	
	if(document.getElementById("identificador").value == ''){
		identificador = false;
	}
	else{
		identificador = true;
	}
	
}