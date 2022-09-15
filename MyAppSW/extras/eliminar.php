<?php

    include_once("conexion.php");

    $codCliente = $_GET['codigoCliente'];
    if(isset($codCliente)){
        
        $consulta = "DELETE FROM cliente WHERE cod_cliente=$codCliente";

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