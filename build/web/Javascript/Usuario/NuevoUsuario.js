$(()=>{
   
   
    $('.datosDir').load('./Vista/DetalleVenta/DatosDireccion.jsp');
    $('.datosPer').load('./Vista/DetalleVenta/DatosPersonales.jsp');
    nuevoUsuario();
});









var nuevoUsuario = ()=>{
      $.validator.addMethod("selectSexo", function (value, element, arg) {
        return arg !== value;
    }, "Seleccione su Sexo");
        $.validator.addMethod("seleccionePais", function (value, element, arg) {
        return arg !== value;
    }, "Seleccione País");
        $.validator.addMethod("seleccioneEstado", function (value, element, arg) {
        return arg !== value;
    }, "Seleccione Estádo");
               $('#formNuevoUsuarioD').validate({
        rules: {
            
            
            userName:{required: true, maxlength: 20, minlength: 3,
            remote: {url: "./DatosUsuario", type: "POST", data: {accion: "validarCorreo"}}},
            pass:{required: true, maxlength: 20, minlength: 3},
            ConfPass:{required: true, maxlength: 20, minlength: 3,equalTo:"#pass"},
            Nombre: {required: true, maxlength: 20, minlength: 3},
            Paterno: {required: true, maxlength: 25, minlength: 5},
            Materno: {required: true, maxlength: 25, minlength: 1},
            Telefono: {maxlength: 10, minlength: 0},
            Nacimiento: {required: true},
            Sexo: {selectSexo: "sex"},
            Correo: {maxlength: 25, minlength: 5,
                remote: {url: "./DatosUsuario", type: "POST", data: {accion: "validarUsuario"}}},

            Pais: {seleccionePais:"pais",required: true},
            Estado: {seleccioneEstado:"estado",required: true},
            Municipio: {required: true, maxlength: 20, minlength: 2},
            Calle: {required: true, maxlength: 20, minlength: 2},
            Colonia: {required: true, maxlength: 20, minlength: 2},
            Postal: {required: true, maxlength: 20, minlength: 1},
            Exterior: {maxlength: 20, minlength: 1},
            Interior: {maxlength: 20, minlength: 1}
        },
        messages: {
            Correo: {
                remote: "El correo ya existe."
            },
            userName:{
                remote: "Éste usuario ya existe."
            }
        },
        submitHandler: function (form) {
   
//   alert($(form).serialize());
//   return false;
// 
    $('.dale').prop("disabled",true);
    
    $(".agregarSpiner").addClass("spinner-border");
    $(".agregarSpiner").addClass("spinner-border-sm");
    
            setTimeout(function ()
    {
                $.ajax({
                    type: 'post',
                    url: './DatosUsuario',
                    data: $(form).serialize(),
                      success: function (res) {
                       $('.contenedorBody').load('./Vista/Venta/Venta.jsp');

                    }
                });
                 }, 3000);
        }
    }); 
};