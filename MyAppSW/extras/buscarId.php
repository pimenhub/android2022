<?php

    include_once("conexion.php");

    $codCliente = $_GET['codigoCliente'];

    if(isset($codCliente)){
        $consulta = "SELECT * FROM cliente WHERE cod_cliente = $codCliente";
        if(mysqli_query($conexion,$consulta)){
            if(mysqli_num_rows(mysqli_query($conexion,$consulta)) > 0){
            
                $registros = mysqli_fetch_array(mysqli_query($conexion,$consulta));
                $retorno = array("cliente" => [$registros]);
                echo json_encode($retorno);
                mysqli_close($conexion);
            }
            else{
                $retornoVacio = array("cliente"=>[["error"=>"0"]]);
                echo json_encode($retornoVacio);
                mysqli_close($conexion);
            }
        }
        else{
            mysqli_close($conexion);
            die("Error la consulta " . mysqli_connect_error());
        }
    }
    else{
        mysqli_close($conexion);
        die("Error en la obtencion de la informacion del ciente");
    }






?>