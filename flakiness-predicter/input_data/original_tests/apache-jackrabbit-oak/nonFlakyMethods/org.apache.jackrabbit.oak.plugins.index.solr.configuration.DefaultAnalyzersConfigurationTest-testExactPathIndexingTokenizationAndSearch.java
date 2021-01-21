@Test public void testExactPathIndexingTokenizationAndSearch() throws Exception {
  try {
    TokenStream ts=exactPathAnalyzer.tokenStream("text",new StringReader("/jcr:a/jcr:b/c"));
    assertTokenStreamContents(ts,new String[]{"/jcr:a/jcr:b/c"});
  }
  finally {
    exactPathAnalyzer.close();
  }
}
