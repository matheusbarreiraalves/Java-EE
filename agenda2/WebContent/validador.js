/**
 * 
 */

function validar(){
	let nome = frmContato.nome.value
	let cpf = frmContato.cpf.value
	let telefone = frmContato.telefone.value
	let sexo = frmContato.sexo.value
	if (nome == ""){
		alert('Preencha o campo nome');
		frmContato.nome.focus()
		return false
	} else if(cpf == ""){
		alert('Preencha o campo cpf');
		frmContato.cpf.focus()
		return false
	} else if(telefone == ""){
		alert('Preencha o campo telefone');
		frmContato.telefone.focus()
		return false
	} else if(sexo == "Feminino" || "Masculino"){
		alert('Preencha o poppey com masculino ou feminino');
		frmContato.sexo.focus()
		return false
	}else{
		document.forms["frmContato"].submit()
	}
		
}