package applikation

class Table(
    val id: String, // Unique identifier for the table
    val name: String, // Name of the table
    var columns: MutableList<TableColumn> = mutableListOf(),// List of columns for the table
    var rows: MutableList<TableRow> = mutableListOf()
)

enum class ColumnDataType {
    TEXT,
    DATE,
    TAGS,
    LINK;
}


data class TableColumn(
    val id: String,
    val dataType: ColumnDataType, // Data type of the column (e.g., Text, Date, Tags, Link)
    var name: String? = "Text" // Name of the column
)

data class TableRow(
    //val id: String,          // Unique identifier for the row
    val tableId: String,     // Identifier of the table to which this row belongs
    val data: MutableMap<String, String> = mutableMapOf()// Key-value pairs representing the data in each column
){
    fun editRow(MapKey: String, data : String){
        this.data.set(MapKey,data)
        println("editRow")
    }
}






