@Test public void testDirectChildrenPathIndexingTokenization() throws Exception {
  try {
    TokenStream ts=directChildrenPathIndexingAnalyzer.tokenStream("text",new StringReader("/jcr:a/b/jcr:c"));
    assertTokenStreamContents(ts,new String[]{"/jcr:a/b"});
    ts=directChildrenPathIndexingAnalyzer.tokenStream("text",new StringReader("/jcr:a"));
    assertTokenStreamContents(ts,new String[]{"/"});
    ts=directChildrenPathIndexingAnalyzer.tokenStream("text",new StringReader("/"));
    assertTokenStreamContents(ts,new String[]{});
  }
  finally {
    directChildrenPathIndexingAnalyzer.close();
  }
}
