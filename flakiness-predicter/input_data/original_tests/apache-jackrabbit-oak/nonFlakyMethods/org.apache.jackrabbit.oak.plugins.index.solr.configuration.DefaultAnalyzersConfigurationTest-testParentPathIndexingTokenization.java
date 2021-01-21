@Test public void testParentPathIndexingTokenization() throws Exception {
  try {
    TokenStream ts=parentPathIndexingAnalyzer.tokenStream("text",new StringReader("/a/b"));
    assertTokenStreamContents(ts,new String[]{"/a/b"});
  }
  finally {
    parentPathIndexingAnalyzer.close();
  }
}
