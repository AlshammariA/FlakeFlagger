@Test public void testSingleNodeCreation() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  builder.child("oak:index").child("solr").setProperty(JCR_PRIMARYTYPE,"oak:QueryIndexDefinition").setProperty("type","solr");
  NodeState before=builder.getNodeState();
  builder.child("newnode").setProperty("prop","val");
  NodeState after=builder.getNodeState();
  NodeState indexed=hook.processCommit(before,after,CommitInfo.EMPTY);
  QueryIndex queryIndex=new SolrQueryIndex("solr",server,configuration);
  FilterImpl filter=new FilterImpl(mock(SelectorImpl.class),"",new QueryEngineSettings());
  filter.restrictPath("/newnode",Filter.PathRestriction.EXACT);
  filter.restrictProperty("prop",Operator.EQUAL,PropertyValues.newString("val"));
  Cursor cursor=queryIndex.query(filter,indexed);
  assertNotNull(cursor);
  assertTrue("no results found",cursor.hasNext());
  IndexRow next=cursor.next();
  assertNotNull("first returned item should not be null",next);
  assertEquals("/newnode",next.getPath());
  assertFalse(cursor.hasNext());
}
