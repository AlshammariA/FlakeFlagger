@Test public void testExactPathFiltering() throws Exception {
  Root root=createRoot();
  Tree tree=root.getTree("/");
  tree.addChild("somenode");
  tree.addChild("someothernode");
  root.commit();
  QueryIndex index=new SolrQueryIndex("solr",server,configuration);
  FilterImpl filter=new FilterImpl(mock(SelectorImpl.class),"",new QueryEngineSettings());
  filter.restrictPath("/somenode",Filter.PathRestriction.EXACT);
  Cursor cursor=index.query(filter,store.getRoot());
  assertCursor(cursor,"/somenode");
}
