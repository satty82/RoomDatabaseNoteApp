package satyam.db

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note :NOte)   // suspend fun cannot be called
                                     // suspend fun can be called inside couroutine scope

    @Query("SELECT * FROM NOte Order By id Desc")
    suspend fun getAllNote(): List<NOte>

    @Insert
    suspend fun addMultipleNotes(vararg note : NOte)

    @Update
    suspend fun updateNote(note : NOte)

}