package lab4.lab.com.lab4

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel

class NotesViewModel: ViewModel()
{
    var log:MediatorLiveData<Int> = MediatorLiveData()
    init {
        log.postValue(0)
    }
}