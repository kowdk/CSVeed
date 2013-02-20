package nl.tweeenveertig.csveed.csv.structure;

import nl.tweeenveertig.csveed.report.CsvException;

import java.util.Iterator;

public class RowImpl implements Row {

    private Line line;

    private Header header;

    public RowImpl(Line line, Header header) {
        this.line = line;
        this.header = header;
    }

    protected Header getHeader() {
        if (this.header == null) {
            throw new CsvException("No header has been found for this file");
        }
        return this.header;
    }

    public RowReport reportOnEndOfLine() {
        return line.reportOnEndOfLine();
    }

    public RowReport reportOnColumn(int columnIndex) {
        return line.reportOnColumn(columnIndex);
    }

    public String get(String columnName) {
        return line.get(header.getIndex(columnName));
    }

    public int size() {
        return line.size();
    }

    public String get(int index) {
        return line.get(index);
    }

    public Iterator<String> iterator() {
        return line.iterator();
    }
}