@Test public void testAllChildrenIndexingTokenization() throws Exception {
  try {
    TokenStream ts=allChildrenPathIndexingAnalyzer.tokenStream("text",new StringReader("/jcr:a/jcr:b/c/jcr:d"));
    assertTokenStreamContents(ts,new String[]{"/jcr:a","/","/jcr:a/jcr:b","/jcr:a/jcr:b/c","/jcr:a/jcr:b/c/jcr:d"});
  }
  finally {
    allChildrenPathIndexingAnalyzer.close();
  }
}
