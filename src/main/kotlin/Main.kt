import java.io.BufferedReader
import java.io.InputStreamReader
import java.sql.DriverManager
import java.util.*

fun main(args: Array<String>) {
     showMenu()
}

fun showMenu() {
    val s = "Opciones: "

    println(" ")
    println(s)
    println("-".repeat(s.length))
    println("0- Exit")
    println("1- Create")
    println("2- Update Empleado")
    println("3- Update Jefe")
    println("4- Insert Empleado")
    println("5- Insert Jefe")
    println("6- Delete Empleado")
    println("6- Delete Jefe")
    println("7- Select")
    introduceNumber() //se ejecuta para introducir uno nuevo
}

private fun introduceNumber() {  //metodo para introducir numeros
    println(" ")
    println("Introdueix un numero (0 per acabar): ")
    val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val num = input.toIntOrNull()
    if (num != null) {
        loopNumbers(num)


    } else {
        println("Entrada no valida. Introduix un numero válid.")
        println("")
        showMenu()
    }
}

fun loopNumbers(number: Int) {
    when (number) {
        0 -> { //asi se sale
            System.exit(0)

        }
        1 -> {
            CreateJefe()
            CreateEmpleado()
            SelectJefeEmpleado()
            showMenu()
        }

        2 -> {
            UpdateEmpleado()
            SelectJefeEmpleado()
            showMenu()
        }

        3 -> {
            UpdateJefe()
            SelectJefeEmpleado()
            showMenu()
        }

        4 -> {
            InsertEmpleado()
            SelectJefeEmpleado()
            showMenu()
        }

        5 -> {
            InsertJefe()
            SelectJefeEmpleado()
            showMenu()
        }

        6 -> {
            DeleteEmpleado()
            SelectJefeEmpleado()
            showMenu()
        }

        7 -> {
            DeleteJefe()
            SelectJefeEmpleado()
            showMenu()
        }
        else -> {
            SelectJefeEmpleado()
            showMenu()
        }
    }
}

fun SelectJefeEmpleado(){
    val url = "jdbc:sqlite:C:\\Users\\amali\\IdeaProjects\\PruebasExamen\\ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)
    val st = con.createStatement()
    val rs = st.executeQuery("select * from EMPLEADO inner join JEFE where EMPLEADO.id_j == JEFE.id_j")
    var count = 0
    while (rs.next()) {
        print("Empleado: ${rs.getInt(1)}\t")
        print(rs.getString(2)+ "\t")
        print(rs.getString(3)+ "\t")
        print("${rs.getInt(4)}\t\n\t")
        print("Jefe: ${rs.getInt(5)}\t")
        print(rs.getString(6)+ "\t")
        print(rs.getString(7)+ "\t\n")
        count++
    }
    print("\n\t Hay $count inserciones")
    st.close()
    con.close()
}