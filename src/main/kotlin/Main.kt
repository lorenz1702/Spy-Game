import applikation.ColumnDataType
import applikation.Table
import applikation.TableColumn
import applikation.TableManager


fun getGreeting(itemToGreet: String) {
    val msg = "Hello $itemToGreet"
    println(msg)
}



fun main() {
    val table1 = Table("Test","Penis")
    val tablecolumn = TableColumn("Penis", ColumnDataType.TEXT)
    table1.columns.add(tablecolumn)
    val tablemanger = TableManager()
    tablemanger.addNewRowToTable(table1)

}


