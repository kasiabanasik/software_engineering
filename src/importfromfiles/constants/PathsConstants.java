package importfromfiles.constants;

public enum PathsConstants {

    PRODUCTS_FILE("src/importfromfiles/resources/alreadyImportedProducts.txt"),
    PRODUCTS_IMPORT_FILE("src/importfromfiles/resources/alreadyImportedProducts.txt"),
    PRICES_HISTORY_FILE("src/importfromfiles/resources/pricesHistory.txt"),
    PRICES_IMPORT_FILE("src/importfromfiles/resources/imports/priceImport.txt"),
    STOCKS_FILE("src/importfromfiles/resources/stocks.txt"),
    STOCKS_IMPORT_FILE("src/importfromfiles/resources/imports/stockImport.txt"),
    SEPARATOR(";");

    String value;

    PathsConstants(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
