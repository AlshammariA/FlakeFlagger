@Test public void testAllChildrenPathMatchingOnRootNode() throws Exception {
  String nodePath="/";
  String descendantPath=nodePath + "jcr:a/jcr:b";
  assertAnalyzesTo(allChildrenPathIndexingAnalyzer,descendantPath,new String[]{"/jcr:a","/","/jcr:a/jcr:b"});
}
