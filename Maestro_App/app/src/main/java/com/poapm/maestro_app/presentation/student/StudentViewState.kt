package com.poapm.maestro_app.presentation.student

import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.domain.model.Class
import com.poapm.maestro_app.domain.model.DetailClass

class StudentViewState: BaseViewState() {

    data class DetailReceived(val detail: List<DetailClass>): BaseViewState()
}