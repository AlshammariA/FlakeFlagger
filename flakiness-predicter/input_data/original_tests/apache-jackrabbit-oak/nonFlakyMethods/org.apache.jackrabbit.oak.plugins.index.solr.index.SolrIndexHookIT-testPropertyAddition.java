@Test public void testPropertyAddition() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  builder.child("oak:index").child("solr").setProperty(JCR_PRIMARYTYPE,"oak:QueryIndexDefinition").setProperty("type","solr");
  NodeState before=builder.getNodeState();
  builder.child("test").setProperty("foo","bar");
  NodeState after=builder.getNodeState();
  NodeState indexed=hook.processCommit(before,after,CommitInfo.EMPTY);
  QueryIndex queryIndex=new SolrQueryIndex("solr",server,configuration);
  FilterImpl filter=new FilterImpl(mock(SelectorImpl.class),"",new QueryEngineSettings());
  filter.restrictProperty("foo",Operator.EQUAL,PropertyValues.newString("bar"));
  Cursor cursor=queryIndex.query(filter,indexed);
  assertNotNull(cursor);
  assertTrue("no results found",cursor.hasNext());
  IndexRow next=cursor.next();
  assertNotNull("first returned item should not be null",next);
  assertEquals("/test",next.getPath());
  assertNotNull(next.getValue("foo"));
  assertEquals(PropertyValues.newString("[bar]"),next.getValue("foo"));
  assertFalse(cursor.hasNext());
}
