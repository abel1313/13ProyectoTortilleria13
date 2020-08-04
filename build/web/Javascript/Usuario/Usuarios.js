$(()=>{
   
   
    $('.enviarEditars').click(function(){
        buscarUsuario($(this).val());
    });
    
    
});



var buscarUsuario = function(buscar)
{
     $.ajax({
        type: 'post',
        url: './Vista/Usuario/ActualizarUsuario.jsp',
        data: {"idUsuario":buscar},
        success: function (res) {
            $('.contenedorBody').html(res); 
            
        }
    });
                
};