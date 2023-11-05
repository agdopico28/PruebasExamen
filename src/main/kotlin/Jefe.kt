import java.sql.DriverManager
import java.util.*

fun CreateJefe(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)

    val st = con.createStatement ()

    val sentSQL = "CREATE TABLE IF NOT EXISTS JEFE ( " +
            "id_j INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre VARCHAR(10), " +
            "dni VARCHAR(10) UNIQUE)"

    st.executeUpdate(sentSQL)
    st.close()
    con.close()
}

fun InsertJefe() {
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val con = DriverManager.getConnection(url)

    try {
        println("Añade una nueva fila (JEFE)")
        println("Introduce el nombre:")
        val nombre = Scanner(System.`in`).nextLine()
        println("Introduce el dni:")
        val dni = Scanner(System.`in`).nextLine()

        val st = con.prepareStatement("INSERT INTO JEFE (nombre, dni) VALUES (?,?)");

        st.setString(1, nombre)
        st.setString(2, dni)

        st.executeUpdate()

        println("Se ha ejecutado el insert correctamente")
        println()

        st.close()
        con.close()
    }catch (e : Exception){
        println(e.message) //este te da el error
        println("Este dni ya pertenece a un usuario")
    }
}

fun UpdateJefe(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)


    println("Actualiza una fila(JEFE)")
    println("Introduce el id:")
    val id = Scanner(System.`in`).nextInt()
    println("Introduce el nuevo nombre:")
    val nombre = Scanner(System.`in`).nextLine()
    println("Introduce la nueva contraseña:")
    val dni = Scanner(System.`in`).nextLine()


    val st = con.prepareStatement("UPDATE JEFE SET nombre = ?,dni = ? where id_j =?")

    st.setString(1,nombre)
    st.setString(2,dni)
    st.setInt(3,id)

    st.executeUpdate()
    st.close()
    con.close()
}

fun DeleteJefe(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)

    println("Borra una fila(JEFE)")
    println("Introduce el id:")
    val id = Scanner(System.`in`).nextInt()

    val st = con.prepareStatement("DELETE FROM JEFE WHERE id_j = ?")

    st.setInt(1,id)

    st.executeUpdate()
    st.close()
    con.close()
}

fun SelectJefe(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)
    val st = con.createStatement()
    val rs = st.executeQuery("select * from  JEFE ")
    var count = 0
    while (rs.next()) {
        print("Jefe: ${rs.getInt(1)}\t")
        print(rs.getString(2)+ "\t")
        print(rs.getString(3)+ "\t\n")
        count++
    }
    print("\n\t Hay $count inserciones")
    st.close()
    con.close()
}