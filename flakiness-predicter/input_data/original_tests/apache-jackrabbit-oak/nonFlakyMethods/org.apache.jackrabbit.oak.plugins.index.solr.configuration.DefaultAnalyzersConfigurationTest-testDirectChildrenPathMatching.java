@Test public void testDirectChildrenPathMatching() throws Exception {
  String nodePath="/a/b/c";
  String childPath=nodePath + "/d";
  assertAnalyzesTo(directChildrenPathIndexingAnalyzer,childPath,new String[]{nodePath});
  assertAnalyzesTo(directChildrenPathSearchingAnalyzer,nodePath,new String[]{nodePath});
  nodePath="/";
  childPath=nodePath + "/jcr:a";
  assertAnalyzesTo(directChildrenPathIndexingAnalyzer,childPath,new String[]{nodePath});
  assertAnalyzesTo(directChildrenPathSearchingAnalyzer,nodePath,new String[]{nodePath});
  String childPath1="/test/jcr:resource";
  String childPath2="/test/resource";
  nodePath="/test";
  assertAnalyzesTo(directChildrenPathIndexingAnalyzer,childPath1,new String[]{nodePath});
  assertAnalyzesTo(directChildrenPathIndexingAnalyzer,childPath2,new String[]{nodePath});
  assertAnalyzesTo(directChildrenPathSearchingAnalyzer,nodePath,new String[]{nodePath});
}
