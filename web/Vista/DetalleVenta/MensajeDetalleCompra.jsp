<%-- 
    Document   : MensajeDetalleCompra
    Created on : Aug 1, 2020, 3:23:06 PM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="contMensajeDetalle">
    <header class="text-light text-center">Elija su pedido</header>
    
    <div class="row p-4">
        <div class="col-6">
            <div class="form-group">
                <button type="button" class="btn float-right envioDomicilioDetalle" id="">Envío a domicilio</button>
            </div>
        </div>
        <div class="col-6">
            <div class="form-group">
                <button type="button" class="btn float-left recogerTortilleria" id="">Recoger en Tortillería</button>
            </div>

        </div>
    </div>
    
    <div class="row">
        <div class="col-6">
            <div class="form-group">
                
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="form-group">
                <button class="btn btn-danger float-right cancelarEnvioDetalle">Cancelar</button>
            </div>
        </div>
    </div>

    
</div>

<div class="confirmarDireccion">
    
    <div class="row p-4">
        <div class="col-6">
            <div class="form-group">
                <button class="btn btnDireccionActualDetalle">Direción actual</button>
            </div>
        </div>
        <div class="col-6">
            <div class="form-group">
                <button class="btn btnDireccionNuevaDetalle">Registrar dirección</button>
            </div>
        </div>

    </div>
</div>

<div class="cocontenedorDireccionDiferente" >
    
    <form id="agregarDireccionDiferente">
        <input type="hidden" name="accion" value="nuevaDireccionDetalle" />
        <div class="direccionDeferente">

        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <button type="submit" class="btn btn-info col-5 float-right agregarDireccionClienteDIrerente">Envío Domicilio</button>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <button type="button" class="btn btn-info col-3 float-left cancelarDireccionDiferente">Cancelar</button>
                </div>
            </div>
            
        </div>
    </form>
    
</div>


<script src="./Javascript/DetalleVenta/MensajeDetalleCompra.js" type="text/javascript"></script>
<link href="./Estilos/DetalleVenta/MensajeDetalleCompra.css" rel="stylesheet" type="text/css"/>