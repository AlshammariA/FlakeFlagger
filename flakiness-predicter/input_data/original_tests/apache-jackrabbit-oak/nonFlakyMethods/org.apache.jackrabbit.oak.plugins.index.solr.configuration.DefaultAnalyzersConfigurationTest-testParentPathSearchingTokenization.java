@Test public void testParentPathSearchingTokenization() throws Exception {
  try {
    TokenStream ts=parentPathSearchingAnalyzer.tokenStream("text",new StringReader("/jcr:a/b/jcr:c"));
    assertTokenStreamContents(ts,new String[]{"/jcr:a/b"});
  }
  finally {
    parentPathSearchingAnalyzer.close();
  }
}
