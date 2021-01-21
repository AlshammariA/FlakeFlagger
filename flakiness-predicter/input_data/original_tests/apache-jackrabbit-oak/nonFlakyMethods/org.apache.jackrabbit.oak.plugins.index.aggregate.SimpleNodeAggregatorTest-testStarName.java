@Test public void testStarName(){
  NodeState root=new MemoryNodeStore().getRoot();
  NodeBuilder builder=root.builder();
  NodeBuilder file=builder.child("file");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE);
  file.child(JCR_CONTENT);
  SimpleNodeAggregator agg=new SimpleNodeAggregator().newRuleWithName(NT_FILE,newArrayList(INCLUDE_ALL));
  String path="/file/jcr:content";
  List<String> actual=newArrayList(agg.getParents(builder.getNodeState(),path));
  assertEquals(newArrayList("/file"),actual);
}
