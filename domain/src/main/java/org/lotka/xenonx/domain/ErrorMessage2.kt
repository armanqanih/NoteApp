package org.lotka.xenonx.domain


data class ErrorMessage2(
    
    var `data`: String? = "",
    
    var error: ErrorDetail? = ErrorDetail("", "", ""),
    

)