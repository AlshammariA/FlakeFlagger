@Test public void testAllChildrenSearchingTokenization() throws Exception {
  try {
    TokenStream ts=allChildrenPathSearchingAnalyzer.tokenStream("text",new StringReader("/jcr:a/jcr:b/jcr:c"));
    assertTokenStreamContents(ts,new String[]{"/jcr:a/jcr:b/jcr:c"});
  }
  finally {
    allChildrenPathSearchingAnalyzer.close();
  }
}
