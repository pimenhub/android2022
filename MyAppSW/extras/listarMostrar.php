<?php

    include_once("conexion.php");

    $consulta = "SELECT * FROM cliente";
    $resultado = mysqli_query($conexion,$consulta);

    if(mysqli_query($conexion,$consulta)){
        if(mysqli_num_rows(mysqli_query($conexion,$consulta)) > 0){
           
            while($registros = mysqli_fetch_array($resultado)){
                $retorno["cliente"][] = $registros;
            }
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


?>