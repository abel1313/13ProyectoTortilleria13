$(()=>{
    
    
    $('.editarCCliente').click(function(){
        EditarCLiente($(this).val());
    });
    
    
});


var EditarCLiente = (valor)=>{
            $.ajax({
            type: 'POST',
            url: './Vista/Cliente/EditarCliente.jsp',
            data: {idCliente:valor},
            success: function (rec) {
                
    $('.contenedorBody').html(rec);
   
            },
            error: function (xhr, status) {
                //console.log('Disculpe, existió un problema');
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                //console.log('Petición realizada');
            }
        });
};

