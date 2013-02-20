package nl.tweeenveertig.csveed.reader;

import nl.tweeenveertig.csveed.bean.instructions.BeanInstructions;
import nl.tweeenveertig.csveed.bean.instructions.BeanProperty;
import nl.tweeenveertig.csveed.csv.structure.Header;
import nl.tweeenveertig.csveed.csv.structure.Line;
import nl.tweeenveertig.csveed.csv.structure.Row;
import nl.tweeenveertig.csveed.report.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NameMatchingStrategy<T> extends AbstractMappingStrategy<T> {

    public static final Logger LOG = LoggerFactory.getLogger(NameMatchingStrategy.class);

    public void instruct(BeanInstructions beanInstructions, Header header, Row row) {

        if (header == null) {
            throw new CsvException("A NameMatchingStrategy requires a header row in the CSV file");
        }

        int indexColumn = 0;
        for (String headerColumn : header.getHeader()) {
            BeanProperty beanProperty = beanInstructions.getBeanPropertyWithName(headerColumn);
            if (beanProperty == null) {
                LOG.info("Column index "+indexColumn+ ": ["+headerColumn+"] -> no match");
                indexColumn++;
                continue;
            }
            indexToProperty.put(indexColumn, beanProperty);
            LOG.info("Column index "+indexColumn+": ["+headerColumn+"] to ["+beanProperty.getName()+"]");
            indexColumn++;
        }
    }

}
