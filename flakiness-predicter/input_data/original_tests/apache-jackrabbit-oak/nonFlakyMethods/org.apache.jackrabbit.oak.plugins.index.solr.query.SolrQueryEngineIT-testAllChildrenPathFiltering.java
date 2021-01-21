@Test public void testAllChildrenPathFiltering() throws Exception {
  Root root=createRoot();
  Tree tree=root.getTree("/");
  Tree parent=tree.addChild("somenode");
  parent.addChild("child1");
  Tree child2=parent.addChild("child2");
  child2.addChild("descendant");
  Tree someothernode=tree.addChild("someothernode");
  someothernode.addChild("someotherchild");
  root.commit();
  QueryIndex index=new SolrQueryIndex("solr",server,configuration);
  FilterImpl filter=new FilterImpl(mock(SelectorImpl.class),"",new QueryEngineSettings());
  filter.restrictPath("/somenode",Filter.PathRestriction.ALL_CHILDREN);
  Cursor cursor=index.query(filter,store.getRoot());
  assertCursor(cursor,"/somenode","/somenode/child1","/somenode/child2","/somenode/child2/descendant");
}
