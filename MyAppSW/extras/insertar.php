<?php
    //Incluir la clase conexion
    include_once("conexion.php");

    //Declaracion de variables para manipular los datos a insertar
    $nomCliente = $_GET['nombreCliente'];
    $apeCliente = $_GET['apellidoCliente'];
    $corCliente = $_GET['correoCliente'];
    $fechCliente = $_GET['fechaNacimientoCliente'];
    $fechaMask = date("Y/m/d",strtotime($fechCliente));
    $limCliente = $_GET['limiteCreditoCliente'];

    //Validar que las claves poseean sus valores respectivos
    if(isset($nomCliente) && isset($apeCliente) 
    && isset($corCliente) && isset($fechCliente) 
    && isset($limCliente)){

    //Realizar la consulta para insertar los datos
    $consulta = "INSERT INTO cliente (nombre_cliente, apellido_cliente, correo_cliente,
    fecha_nacimiento_cliente, limite_credito_cliente) VALUES ('{$nomCliente}', '{$apeCliente}', 
    '{$corCliente}', '{$fechaMask}', {$limCliente})";

        if(mysqli_query($conexion, $consulta)){
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