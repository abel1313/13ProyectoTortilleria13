$(()=>{
    
//$('.agregarUsuario').click(function(){
//    agregar('./Vista/Venta/Venta.jsp');
//    
//});

$('.agregarVenta').click(function(){
    agregar('./Vista/Venta/Venta.jsp');
});
$('.actualizarUsuario').click(()=>{
    
    agregar('./Vista/Usuario/ActualizarUsuario.jsp');
});
$('.mostrarUsuario').click(()=>{
    
    agregar('./Vista/Usuario/Usuario.jsp');
});

$('.ocultarContenedor').click(function(){
    $('.contenedorBody').empty();
});

$('.agregarProduc').click(function(){
    agregar('./Vista/Producto/AgregarProducto.jsp');
});

$('.mostrarProducto').click(function(){
    agregar('./Vista/Producto/Producto.jsp');
});

    
});




function agregar(vista)
{
    $('.contenedorBody').load(vista);
     $(".navbar-collapse").removeClass('show');
}




