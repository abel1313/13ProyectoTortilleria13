$(()=>{
   
   $(".editarProducto").click(function(){
       alert("Diste");
       editarProducto($(this).val());
   });
    
});


var editarProducto = function(indice)
{
         $.ajax({
            type: 'POST',
            url: './Vista/Producto/EditarProducto.jsp',
            data: {indice:indice},
            success: function (rec) {
                $(".contenedorBody").html(rec);
            },
            error: function (xhr, status) {
                
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                
            }
        });
           
};
