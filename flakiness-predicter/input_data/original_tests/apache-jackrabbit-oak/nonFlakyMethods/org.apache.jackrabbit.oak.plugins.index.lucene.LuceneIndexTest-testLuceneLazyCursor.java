@Test public void testLuceneLazyCursor() throws Exception {
  NodeBuilder index=builder.child(INDEX_DEFINITIONS_NAME);
  newLuceneIndexDefinition(index,"lucene",ImmutableSet.of(TYPENAME_STRING));
  NodeState before=builder.getNodeState();
  builder.setProperty("foo","bar");
  for (int i=0; i < LuceneIndex.LUCENE_QUERY_BATCH_SIZE; i++) {
    builder.child("parent").child("child" + i).setProperty("foo","bar");
  }
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  IndexTracker tracker=new IndexTracker();
  tracker.update(indexed);
  QueryIndex queryIndex=new LuceneIndex(tracker,analyzer,null);
  FilterImpl filter=createFilter(NT_BASE);
  filter.restrictProperty("foo",Operator.EQUAL,PropertyValues.newString("bar"));
  Cursor cursor=queryIndex.query(filter,indexed);
  List<String> paths=copyOf(transform(cursor,new Function<IndexRow,String>(){
    public String apply(    IndexRow input){
      return input.getPath();
    }
  }
));
  assertTrue(!paths.isEmpty());
  assertEquals(LuceneIndex.LUCENE_QUERY_BATCH_SIZE + 1,paths.size());
}
