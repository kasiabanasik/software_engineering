package importfromfiles.constants;

public enum FilesConstants {

    PRODUCTS_FILE("/Users/kbanasik/pierce/study/one/src/importfromfiles/resources/alreadyImportedProducts.txt"),
    PRODUCTS_IMPORT_FILE("/Users/kbanasik/pierce/study/one/src/importfromfiles/resources/alreadyImportedProducts.txt"),
    PRICES_HISTORY_FILE("/Users/kbanasik/pierce/study/one/src/importfromfiles/resources/pricesHistory.txt"),
    PRICES_IMPORT_FILE("/Users/kbanasik/pierce/study/one/src/importfromfiles/resources/imports/priceImport.txt"),
    STOCKS_FILE("/Users/kbanasik/pierce/study/one/src/importfromfiles/resources/stocks.txt"),
    STOCKS_IMPORT_FILE("/Users/kbanasik/pierce/study/one/src/importfromfiles/resources/imports/stockImport.txt"),
    SEPARATOR(";");

    String value;

    FilesConstants(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
