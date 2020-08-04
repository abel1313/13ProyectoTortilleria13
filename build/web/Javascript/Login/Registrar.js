
$(() => {
    
    $('.irSesion a').click(function(){
        $(location).attr('href','./Login.jsp');
    });
    $('.cancerarRegistro').click(() => {
        $('.registrarUsuario').css({"display": "none"});

    });
    $.validator.addMethod("selectSexo", function (value, element, arg) {
        return arg !== value;
    }, "Seleccione su Sexo");
        $.validator.addMethod("seleccionePais", function (value, element, arg) {
        return arg !== value;
    }, "Seleccione País");
        $.validator.addMethod("seleccioneEstado", function (value, element, arg) {
        return arg !== value;
    }, "Seleccione Estádo");
    
    $('#formRegistrarUsuario').validate({
        rules: {

            Nombre: {required: true, maxlength: 20, minlength: 3},
            Paterno: {required: true, maxlength: 25, minlength: 5},
            Materno: {required: true, maxlength: 25, minlength: 1},
            Telefono: {required: true, maxlength: 10, minlength: 0},
            Nacimiento: {required: true},
            Sexo: {selectSexo: "sex"},
            Correo: {maxlength: 25, minlength: 5,
                remote: {url: "../../DatosUsuario", type: "POST", data: {accion: "validarCorreo"}}},

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
            }
        },
        submitHandler: function (form) {



//   alert($(form).serialize());
//           return false;
// 
// 
            $.ajax({
                type: 'post',
                url: '../../DatosUsuario',
                data: $(form).serialize(),

                success: function (res) {
                    signOutGoogle();
//                        return false;
//                        $(location).attr('href',"./Login.jsp");

                }
            });



        }
    });





    $('#formPreRegistro').validate({
        rules: {

            userName: {required: true, maxlength: 20, minlength: 3},
            Pass: {required: true, maxlength: 25, minlength: 1},
            ConfPass: {required: true, maxlength: 25, minlength: 1, equalTo: "#pass"}
        },

        submitHandler: function (form) {
            $("#userName").val($("#user").val());
            $("#passUser").val($("#pass").val());

            $(".registrarUsuario").show();

        }
    });


});


function signOutGoogle() {

    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {

//     return false;
        $(location).attr('href', './Login.jsp');


    });


}


function onLoad() {
    gapi.load('auth2', function () {
        gapi.auth2.init();
    });
}


 