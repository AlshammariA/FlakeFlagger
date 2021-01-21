@Test public void diffWithMove(){
  String base=mk.commit("","+\"/a\":{\"b\":{}}",mk.getHeadRevision(),null);
  String head=mk.commit("","+\"/a/c\":{}+\"/a/d\":{}-\"/a/b\"",base,null);
  String diff=mk.diff(base,head,"/a",0);
  assertTrue(diff.contains("c"));
  assertTrue(diff.contains("d"));
}
