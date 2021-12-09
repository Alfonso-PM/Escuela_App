package com.poapm.alumno_app.domain.repository

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.data.dto.ClassResponse

interface ClassRepository {
    fun getAllClasses(): Either<Failure, ClassResponse>
}