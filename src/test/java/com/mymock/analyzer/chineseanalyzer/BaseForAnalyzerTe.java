/**
 * Copyright 2015 jianglibo@gmail.com
 *
 */
package com.mymock.analyzer.chineseanalyzer;

import java.util.Arrays;

/**
 * @author jianglibo@gmail.com
 *         2016年6月2日
 *
 */
public class BaseForAnalyzerTe {

    public void printme(Object...os) {
        if (os.length > 0) {
            System.out.print(os[0]);
            if (os.length > 1) {
                System.out.print(": ");
                System.out.print(os[1]);
                
                for(Object o: Arrays.copyOfRange(os, 2, os.length)) {
                    System.out.print(", " + o.toString());
                }
            }
            System.out.println();
        }
    }
}
