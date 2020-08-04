$(()=>{
    
       $('#actualizarProducto').keyup(function(e){  
        var code = (e.keyCode ? e.keyCode : e.which);
         

        if(code === 13)
        {
            if ($(this).val() == 0)
            {
                $("#errorCantidad").text("Ingrese un numero mayor a 0");
            }else
            {
                actualizarProducto($(this).val());
            }
        }    
        
        if($("#actualizarProducto").val() == "")
        {
            $("#errorCantidad").text("");
        }

    });
                
});

var actualizarProducto = function (cant)
{
    $.ajax({
        type: 'post',
        url: './DatosProducto',
        data: {"accion":"actualizarProducto","cantidad":cant},
                            cache: false,

        success: function () {

          $('.contenedorBody').load('./Vista/Venta/Venta.jsp');
          
            setTimeout(function () {
                $('.Mensaje').load('./Vista/Menu/Mensaje.jsp');
            }, 500);
          
        }
    });

};
