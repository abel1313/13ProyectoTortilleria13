$(()=>{
    
   $('.todosClientes').load('./Vista/Cliente/Clientes.jsp'); 
   
      buscarCliente("");
       
        $('#buscarCli').keyup(function(){
            
        buscarCliente($(this).val());
            
        
    });
    
});

var buscarCliente = function(buscar)
{
    
     $.ajax({
        type: 'post',
        url: 'DatosCliente',
        data: {"accion":"buscarCliente","buscarCliente":buscar},
        success: function () {
            $('.todosClientes').load('./Vista/Cliente/Clientes.jsp'); 
            
        }
    });
                
};

