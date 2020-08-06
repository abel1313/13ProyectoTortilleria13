$(()=>{
   
    
    $('.mostrarEmpleados').load('./Vista/Empleado/Empleados.jsp');
   buscarEmpleados("");
   
        $('#busEmpleado').keyup(function(){
        
        buscarEmpleados($(this).val());
            
        
    });
    
});


var buscarEmpleados = function(buscar)
{
    
     $.ajax({
        type: 'post',
        url: 'ServletEmp',
        data: {"accion":"buscarEmpleado","busca":buscar},
        success: function () {
            $('.mostrarEmpleados').load('./Vista/Empleado/Empleados.jsp'); 
            
        }
    });
                
};