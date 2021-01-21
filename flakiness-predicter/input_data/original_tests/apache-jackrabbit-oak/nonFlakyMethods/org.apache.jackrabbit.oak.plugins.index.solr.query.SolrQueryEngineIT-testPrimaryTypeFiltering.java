@Test public void testPrimaryTypeFiltering() throws Exception {
  Root root=createRoot();
  Tree tree=root.getTree("/");
  tree.addChild("asamplenode").setProperty("jcr:primaryType","nt:unstructured");
  tree.addChild("afoldernode").setProperty("jcr:primaryType","nt:folder");
  tree.addChild("anothersamplenode").setProperty("jcr:primaryType","nt:unstructured");
  root.commit();
  QueryIndex index=new SolrQueryIndex("solr",server,configuration);
  SelectorImpl selector=mock(SelectorImpl.class);
  Set<String> primaryTypes=new HashSet<String>();
  primaryTypes.add("nt:folder");
  when(selector.getPrimaryTypes()).thenReturn(primaryTypes);
  FilterImpl filter=new FilterImpl(selector,"select * from [nt:folder]",new QueryEngineSettings());
  Cursor cursor=index.query(filter,store.getRoot());
  assertCursor(cursor,"/afoldernode");
}
