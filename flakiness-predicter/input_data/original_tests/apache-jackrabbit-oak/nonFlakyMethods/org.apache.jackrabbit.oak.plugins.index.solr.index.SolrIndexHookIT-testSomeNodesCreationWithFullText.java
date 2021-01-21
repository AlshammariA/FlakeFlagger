@Test public void testSomeNodesCreationWithFullText() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  builder.child("oak:index").child("solr").setProperty(JCR_PRIMARYTYPE,"oak:QueryIndexDefinition").setProperty("type","solr");
  NodeState before=builder.getNodeState();
  builder.child("test").setProperty("foo","bar");
  builder.child("a").setProperty("foo","bar");
  builder.child("a").child("b").setProperty("foo","bar");
  builder.child("a").child("b").child("c").setProperty("foo","bar");
  NodeState after=builder.getNodeState();
  NodeState indexed=hook.processCommit(before,after,CommitInfo.EMPTY);
  QueryIndex queryIndex=new SolrQueryIndex("solr",server,configuration);
  FilterImpl filter=new FilterImpl(mock(SelectorImpl.class),"",new QueryEngineSettings());
  filter.restrictProperty("foo",Operator.EQUAL,PropertyValues.newString("bar"));
  filter.restrictFulltextCondition("bar");
  Cursor cursor=queryIndex.query(filter,indexed);
  Set<String> paths=newHashSet();
  while (cursor.hasNext()) {
    paths.add(cursor.next().getPath());
  }
  assertTrue(paths.remove("/test"));
  assertTrue(paths.remove("/a"));
  assertTrue(paths.remove("/a/b"));
  assertTrue(paths.remove("/a/b/c"));
  assertTrue(paths.isEmpty());
}
