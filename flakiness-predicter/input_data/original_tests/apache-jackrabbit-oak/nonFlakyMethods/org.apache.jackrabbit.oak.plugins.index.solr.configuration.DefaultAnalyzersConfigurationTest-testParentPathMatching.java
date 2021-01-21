@Test public void testParentPathMatching() throws Exception {
  String parentPath="/a/b";
  String nodePath=parentPath + "/jcr:c";
  assertAnalyzesTo(parentPathIndexingAnalyzer,parentPath,new String[]{parentPath});
  assertAnalyzesTo(parentPathSearchingAnalyzer,nodePath,new String[]{parentPath});
}
