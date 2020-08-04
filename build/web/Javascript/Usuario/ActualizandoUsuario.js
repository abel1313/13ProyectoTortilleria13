$(function(){
   
    
    $.validator.addMethod("selectSexo", function(value, element, arg){
  return arg !== value;
 }, "Seleccione su Sexo");
 

//$('.l').click(function(){
//       alert($('#formActUsu').serialize());
//   return false;
//});

           $('#formActUsu').validate({
        rules: {
           UsrName:{required: true, maxlength: 20, minlength: 3},
           NuevaContra:{required: true, maxlength: 10, minlength: 2},
           ConPass:{required: true, maxlength: 10, minlength: 2,equalTo:"#pass"},
           Nombre:{required: true, maxlength: 20, minlength: 3}, 
           Paterno:{required: true, maxlength: 25, minlength: 5},
           Materno:{required: true, maxlength: 25, minlength: 1},
           Telefono:{required: true, maxlength: 10, minlength: 0},
           Nacimiento:{required: true},
           Sexo: {selectSexo: "sex"},
            Pais: {required: true, maxlength: 20, minlength: 2},
            Estado: {required: true, maxlength: 20, minlength: 2},
            Municipio: {required: true, maxlength: 20, minlength: 2},
            Calle: {required: true, maxlength: 20, minlength: 2},
            Colonia: {required: true, maxlength: 20, minlength: 2},
            Postal: {required: true, maxlength: 20, minlength: 1},
            Exterior: {maxlength: 20, minlength: 1},
            Interior: {required: true, maxlength: 20, minlength: 1},
        Correos: {required: true, maxlength: 50, remote: {url: "./DatosUsuario", type: "post", 
        data: {accion: "validarCorreoActualizar"}}}
            
        },            
        messages: {
                Correos: {
                    remote: "El correo ya existe."
                }
            },
        submitHandler: function (form) {
        
           
   
//   alert($(form).serialize());
//   
//   return false;
 
 
                $.ajax({
                    type: 'post',
                    url: './DatosUsuario',
                    data: $(form).serialize(),
  
                    success: function (res) {
                        
//                        return false;
//                        $(location).attr('href',"./Login.jsp");

                    }
                });
                
               

        }
    }); 
    
});

