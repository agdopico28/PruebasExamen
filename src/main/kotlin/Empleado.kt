import java.sql.DriverManager
import java.util.*

fun CreateEmpleado(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)

    val st = con.createStatement ()

    val sentSQL = "CREATE TABLE IF NOT EXISTS EMPLEADO ( " +
            "id_e INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre VARCHAR(10), " +
            "dni VARCHAR(10) UNIQUE," +
            "id_j INTEGER, FOREIGN KEY (id_j) REFERENCES JEFE(id_j) )"

    st.executeUpdate(sentSQL)
    st.close()
    con.close()
}

fun InsertEmpleado() {
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val con = DriverManager.getConnection(url)


    println("Añade una nueva fila (EMPLEADO)")
    println("Introduce el nombre:")
    val nombre = Scanner(System.`in`).nextLine()
    println("Introduce el dni:")
    val dni = Scanner(System.`in`).nextLine()
    println("Introduce el id del jefe:")
    val id_j = Scanner(System.`in`).nextInt()

    val st = con.prepareStatement("INSERT OR REPLACE INTO EMPLEADO (nombre, dni, id_j) VALUES (?,?,?)");

    st.setString(1,nombre)
    st.setString(2,dni)
    st.setInt(3,id_j)

    st.executeUpdate()

    println("Se ha ejecutado el insert correctamente")
    println()

    st.close()
    con.close()
}

fun UpdateEmpleado(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)


    println("Actualiza una fila(EMPLEADO)")
    println("Introduce el id:")
    val id = Scanner(System.`in`).nextInt()
    println("Introduce el nuevo nombre:")
    val nombre = Scanner(System.`in`).nextLine()
    println("Introduce la nueva contraseña:")
    val dni = Scanner(System.`in`).nextLine()


    val st = con.prepareStatement("UPDATE EMPLEADO SET nombre = ?,dni = ? where id_e =?")

    st.setString(1,nombre)
    st.setString(2,dni)
    st.setInt(3,id)

    st.executeUpdate()
    st.close()
    con.close()
}


fun DeleteEmpleado(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)

    println("Borra una fila(EMPLEADO)")
    println("Introduce el id:")
    val id = Scanner(System.`in`).nextInt()

    val st = con.prepareStatement("DELETE FROM EMPLEADO WHERE id_e = ?")

    st.setInt(1,id)

    st.executeUpdate()
    st.close()
    con.close()
}