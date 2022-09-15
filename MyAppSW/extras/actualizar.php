<?php

    include_once("conexion.php");

    $codCliente = $_GET['codigoCliente'];

    if(isset($codCliente)){

        $nomCliente = $_GET['nombreCliente'];
        $apeCliente = $_GET['apellidoCliente'];
        $correoCliente = $_GET['correoCliente'];
        $fechaCliente = $_GET['fechaNacimientoCliente'];
        $fechaMask = date("Y/m/d",strtotime($fechaCliente));
        $limiteCliente = $_GET['limiteCreditoCliente'];

        $consulta = "UPDATE cliente SET nombre_cliente='$nomCliente', apellido_cliente='$apeCliente',
        correo_cliente='$correoCliente', fecha_nacimiento_cliente='$fechaMask', 
        limite_credito_cliente=$limiteCliente WHERE cod_cliente=$codCliente";

        if(mysqli_query($conexion,$consulta)){
            $retorno = array('resultado'=>'OK');
            echo json_encode($retorno);
            mysqli_close($conexion);
        }
        else{
            mysqli_close($conexion);
            die("Error en la Insercion " . mysqli_connect_error());
        }

    }
    else{
        mysqli_close($conexion);
        die("Error en la obtencion de la informacion del ciente");
    }




?>