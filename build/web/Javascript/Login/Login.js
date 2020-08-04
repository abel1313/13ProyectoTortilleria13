$(()=>{
    
        $('#idContrasena').keypress(function (e) {
            
        var code = (e.keyCode ? e.keyCode : e.which);
        if (code == 13) {
            $("#idContrasena").blur();
            IniciarSesion();
        }
    });
    $("#idUsuario").focus();
    $(".btnIniciarSession").click(IniciarSesion);
    
    $('#idUsuario').keyup(limpiarMensaje);
    $('#idContrasena').keyup(limpiarMensaje);
    
    $('.registrarse a').click(()=>{
        
        
        $(location).attr('href','./Registrarse.jsp');
        
    });

    
});

function limpiarMensaje()
{   
    
    $('#mensaje').empty();
}

function IniciarSesion()
{
    
    $('.btnIniciarSession').prop("disabled",true);
    $('.btnIniciarSession').addClass("buttonload");
    $(".iIniciarSesion").addClass("fa fa-spinner");
    $(".iIniciarSesion").addClass("fa-spin");
    
//    $('.loaders').css({'display': 'block'});
    setTimeout(function ()
    {
        $.ajax({
            type: 'POST',
            url: '../../DatosUsuario',
            data: {accion: "accederSistema", userName: $('#idUsuario').val(), contra: $('#idContrasena').val()},
            success: function (rec) {
                       location.reload();
                //                
//                setTimeout(function ()
//                {
//                    if (rec != 1) {
//

//                        $('#idUsuario').val("");
//                        $('#idContrasena').val("");
////                        $('.loaders').css({'display': 'none'});
//                    } else {
//
//                        location.reload();
//                    }
//                }, 2000);


            },
            error: function (xhr, status) {
                console.log('Disculpe, existió un problema');
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                console.log('Petición realizada');
            }
        });

    }, 3000);
}


  