package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutCMU() throws Exception {
        assertThat(queryProcessor.process("CMU"), containsString("mIcHiGaN"));
    }

    @Test
    public void isNotCaseSensitiveCMU() throws Exception {
        assertThat(queryProcessor.process("cmu"), containsString("mIcHiGaN"));
    }

    @Test
    public void knowsAboutYourName() throws Exception {
        assertThat(queryProcessor.process("your name"), containsString("LF-Team"));
    }

}
