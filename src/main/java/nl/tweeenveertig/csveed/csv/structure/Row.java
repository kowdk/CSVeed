package nl.tweeenveertig.csveed.csv.structure;

public interface Row extends Iterable<String> {

    int size();

    String get(int index);

    String get(String columnName);

    RowReport reportOnEndOfLine();

    RowReport reportOnColumn(int columnIndex);

}
