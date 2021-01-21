@Test public void testNodeNameWrongParentType(){
  NodeState root=new MemoryNodeStore().getRoot();
  NodeBuilder builder=root.builder();
  NodeBuilder file=builder.child("file");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE + "_");
  file.child(JCR_CONTENT);
  SimpleNodeAggregator agg=new SimpleNodeAggregator().newRuleWithName(NT_FILE,newArrayList(JCR_CONTENT));
  String path="/file/jcr:content";
  List<String> actual=newArrayList(agg.getParents(builder.getNodeState(),path));
  assertTrue(actual.isEmpty());
}
