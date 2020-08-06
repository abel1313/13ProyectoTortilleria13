/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(()=>{
   
   
    $('.enviarEditars').click(function(){
        buscarEmpleado($(this).val());
    });
    
    
});



var buscarEmpleado = function(buscar)
{
     $.ajax({
        type: 'post',
        url: './Vista/Empleado/ActualizarEmpleado.jsp',
        data: {"idEmpleado":buscar},
        success: function (res) {
            $('.contenedorBody').html(res); 
            
        }
    });
                
};

