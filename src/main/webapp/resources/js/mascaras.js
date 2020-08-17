/**
 * 
 */

function mascara(o,f){
    v_obj=o;
    v_fun=f;
    var evt = window.event; 
	if(!evt){
		setTimeout("execmascara()",1);
	}else{
		if (evt.keyCode) { 
            tecla = evt.keyCode; 
		} else if (evt.which) { 
            tecla = evt.which; 
		}
		if(tecla != 8){
			setTimeout("execmascara()",1);
		}
		
	}	
}

function execmascara(){
	var tecla = ""; 
    v_obj.value=v_fun(v_obj.value);
}

function cpf(v){
    v=v.replace(/\D/g,"")                    //Remove tudo o que nao eh d�gito
    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto digitos
    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto digitos
                                             //de novo (para o segundo bloco de numeros)
    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um h�fen entre o terceiro e o quarto digitos
    return v;
}

function data(v){
	v = v.replace(/\D/g,""); 						//Remove tudo o que nao eh d�gito
	v = v.replace(/^(\d{4})/gi,"$1/"); 				//Coloca uma barra entre o quarto e o quinto digito
	v = v.replace(/^(\d{2})/gi,"$1/");				//Coloca uma barra entre o segundo e o terceiro digito

    return v.substring(0,10);
}