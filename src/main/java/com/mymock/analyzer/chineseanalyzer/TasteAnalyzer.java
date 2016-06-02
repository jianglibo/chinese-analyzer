package com.mymock.analyzer.chineseanalyzer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.Version;

/**
 * http://www.solr-start.com/javadoc/solr-lucene/org/apache/lucene/analysis/package-summary.html
 * http://www.matrix67.com/blog/archives/4212
 * http://www.solr-start.com/javadoc/solr-lucene/org/apache/lucene/analysis/Analyzer.html#tokenStream-java.lang.String-java.io.Reader-
 * @author jianglibo@gmail.com
 *
 */
public class TasteAnalyzer extends BaseForAnalyzerTe {

    public void taste() throws IOException {
        Version matchVersion = Version.LUCENE_6_0_1; // Substitute desired Lucene version for XY
        Analyzer analyzer = new SmartChineseAnalyzer(); // or any other analyzer
        TokenStream ts = analyzer.tokenStream("myfield", new StringReader("他说的确实在理。"));
        // The Analyzer class will construct the Tokenizer, TokenFilter(s), and CharFilter(s),
        // and pass the resulting Reader to the Tokenizer.
        OffsetAttribute offsetAtt = ts.addAttribute(OffsetAttribute.class);
        CharTermAttribute charTermAtt = ts.addAttribute(CharTermAttribute.class);
        try {
            ts.reset(); // Resets this stream to the beginning. (Required)
            while (ts.incrementToken()) {
                // Use AttributeSource.reflectAsString(boolean)
                // for token stream debugging.
                printme("token: ", ts.reflectAsString(true));
                printme("token start offset: ", offsetAtt.startOffset());
                printme("  token end offset: " + offsetAtt.endOffset());
                printme(charTermAtt.toString());
            }
            ts.end(); // Perform end-of-stream operations, e.g. set the final offset.
        } finally {
            ts.close(); // Release resources associated with this stream.
        }
    }
}
