$(()=>{
   
    
    $('.mostrarUsuarios').load('./Vista/Usuario/Usuarios.jsp');
   buscarUsuarios("");
   
        $('#busUsuario').keyup(function(){
        
        buscarUsuarios($(this).val());
            
        
    });
    
});


var buscarUsuarios = function(buscar)
{
    
     $.ajax({
        type: 'post',
        url: 'DatosUsuario',
        data: {"accion":"buscarUsuario","busca":buscar},
        success: function () {
            $('.mostrarUsuarios').load('./Vista/Usuario/Usuarios.jsp'); 
            
        }
    });
                
};