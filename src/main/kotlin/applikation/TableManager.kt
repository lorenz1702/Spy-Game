package applikation

import java.sql.RowId

class TableManager(){

    private fun createNewRow(table: Table): TableRow {
        val rowindex: Int = table.rows.size
        val tableName: String = table.name
        //return TableRow(rowindex.toString(), tableName)
        return TableRow(tableName)
    }

    private fun initializeRowMap(table:Table, tableRow: TableRow):TableRow{
        // Row Map create after the colomus
        table.columns.forEach { tableRow.data.put(it.id,"Empty")}
        return tableRow
    }

    private fun addRowToTable(table:Table, tableRow: TableRow):Table{
        //Add tableRow to Table
        table.rows.add(tableRow)
        return table
    }
    fun addNewRowToTable(table:Table):Table{
        var tempRow = createNewRow(table)
        tempRow = initializeRowMap(table,tempRow)
        addRowToTable(table,tempRow)
        println("Add new Row")
        return table
    }

    fun modifiyRow(table:Table,tableRowId: Int, mapkey:String, mapdata:String){
        val row = table.rows.get(tableRowId)
        row.editRow(mapkey,mapdata)
        table.rows.set(tableRowId, row)
    }

    fun deleteRowFromTable(table: Table, tableRowId: Int){
        table.rows.removeAt(tableRowId)

        println("Delete Row")
    }

    fun deleteColumFromTable(){

    }

    fun moveRowPosition(Position:Int){
        println("Move Row")
    }
}