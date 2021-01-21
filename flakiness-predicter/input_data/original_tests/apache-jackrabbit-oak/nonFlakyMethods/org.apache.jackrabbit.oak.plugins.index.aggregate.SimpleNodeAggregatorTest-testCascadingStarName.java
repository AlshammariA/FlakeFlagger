@Test public void testCascadingStarName(){
  NodeState root=new MemoryNodeStore().getRoot();
  NodeBuilder builder=root.builder();
  NodeBuilder folder=builder.child("folder");
  folder.setProperty(JCR_PRIMARYTYPE,NT_FOLDER);
  NodeBuilder file=folder.child("file");
  file.setProperty(JCR_PRIMARYTYPE,NT_FILE);
  file.child(JCR_CONTENT);
  SimpleNodeAggregator agg=new SimpleNodeAggregator().newRuleWithName(NT_FOLDER,newArrayList("file")).newRuleWithName(NT_FILE,newArrayList(INCLUDE_ALL));
  String path="/folder/file/jcr:content";
  List<String> actual=newArrayList(agg.getParents(builder.getNodeState(),path));
  assertEquals(newArrayList("/folder/file","/folder"),actual);
}
