package satyam.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NOte(

    @ColumnInfo(name="note_title")  // If u want different colum name (for below)
    val title : String,
    val note : String
){
    @PrimaryKey(autoGenerate = true)  // This means the id will be generated automatically
    var id : Int = 0

}