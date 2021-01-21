@Test public void testDirectChildrenPathSearchingTokenization() throws Exception {
  try {
    TokenStream ts=directChildrenPathSearchingAnalyzer.tokenStream("text",new StringReader("/jcr:a/jcr:b"));
    assertTokenStreamContents(ts,new String[]{"/jcr:a/jcr:b"});
  }
  finally {
    directChildrenPathSearchingAnalyzer.close();
  }
}
