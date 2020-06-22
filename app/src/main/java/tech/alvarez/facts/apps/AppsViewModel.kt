package tech.alvarez.facts.apps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.alvarez.facts.App
import tech.alvarez.facts.Category
import tech.alvarez.facts.util.Util

class AppsViewModel(private val category: Category) : ViewModel() {

    val information = MutableLiveData<List<App>>()

    fun reloadInformation() = when (category) {
        Category.APPS -> information.value = Util.userApps().sortedBy { it.name }
        Category.PACKAGES -> information.value = Util.systemApps().sortedBy { it.name }
        else -> information.value = emptyList()
    }
}