@Test public void testAllChildrenPathMatching() throws Exception {
  String nodePath="/jcr:a/jcr:b/c";
  String descendantPath=nodePath + "/d/jcr:e";
  assertAnalyzesTo(allChildrenPathIndexingAnalyzer,descendantPath,new String[]{"/jcr:a","/","/jcr:a/jcr:b","/jcr:a/jcr:b/c","/jcr:a/jcr:b/c/d","/jcr:a/jcr:b/c/d/jcr:e"});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,nodePath,new String[]{nodePath});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,"/jcr:a",new String[]{"/jcr:a"});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,"/jcr:a/b",new String[]{"/jcr:a/b"});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,"/a/b/c",new String[]{"/a/b/c"});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,"/a/b/c/d",new String[]{"/a/b/c/d"});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,"/a/b/c/d/jcr:e",new String[]{"/a/b/c/d/jcr:e"});
  assertAnalyzesTo(allChildrenPathSearchingAnalyzer,"/",new String[]{"/"});
}
