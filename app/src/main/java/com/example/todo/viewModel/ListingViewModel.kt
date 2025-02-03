import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.Todo
import com.example.todo.data.repo.ListingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class ListingViewModel @Inject constructor(private val listingRepo: ListingRepo) : ViewModel() {


}
