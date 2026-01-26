package com.example.eShop.Exception.ProductExceptions;



public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }

}


// @ExceptionHandler(ProductNotFoundException.class)
// public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
//     ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
// }