@Test public void testPropertyFiltering() throws Exception {
  Root root=createRoot();
  Tree tree=root.getTree("/");
  tree.addChild("somenode").setProperty("foo","bar");
  tree.addChild("someothernode").setProperty("foo","bard");
  tree.addChild("anotherone").setProperty("foo","a fool's bar");
  root.commit();
  QueryIndex index=new SolrQueryIndex("solr",server,configuration);
  FilterImpl filter=new FilterImpl(mock(SelectorImpl.class),"",new QueryEngineSettings());
  filter.restrictProperty("foo",Operator.EQUAL,PropertyValues.newString("bar"));
  Cursor cursor=index.query(filter,store.getRoot());
  assertCursor(cursor,"/somenode","/anotherone");
}
