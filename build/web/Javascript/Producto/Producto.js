$(()=>{
    
    $(".productos").load("./Vista/Producto/TodosProductos.jsp");
    
    buscarProducto("");
    
    $("#buscarPrducto").keyup(function () {
        buscarProducto($(this).val());
    });
    

    
});



var buscarProducto = function(filtro)
{
    
         $.ajax({
            type: 'POST',
            url: 'DatosProducto',
            data: {accion: "DatosProducto",filtro:filtro},
            success: function (rec) {
                $(".productos").load("./Vista/Producto/TodosProductos.jsp");
            },
            error: function (xhr, status) {
                
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                
            }
        });
           
};