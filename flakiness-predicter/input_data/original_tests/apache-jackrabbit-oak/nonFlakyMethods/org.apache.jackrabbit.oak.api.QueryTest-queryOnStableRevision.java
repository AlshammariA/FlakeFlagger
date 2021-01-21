@Test public void queryOnStableRevision() throws Exception {
  ContentSession s=repository.login(null,null);
  Root r=s.getLatestRoot();
  Tree t=r.getTree("/").addChild("test");
  t.addChild("node1").setProperty("jcr:primaryType","nt:base");
  t.addChild("node2").setProperty("jcr:primaryType","nt:base");
  t.addChild("node3").setProperty("jcr:primaryType","nt:base");
  r.commit();
  ContentSession s2=repository.login(null,null);
  Root r2=s2.getLatestRoot();
  r.getTree("/test").getChild("node2").remove();
  r.commit();
  Result result=r2.getQueryEngine().executeQuery("test//element(*, nt:base)",Query.XPATH,Long.MAX_VALUE,0,QueryEngine.NO_BINDINGS,QueryEngine.NO_MAPPINGS);
  Set<String> paths=new HashSet<String>();
  for (  ResultRow rr : result.getRows()) {
    paths.add(rr.getPath());
  }
  assertEquals(new HashSet<String>(Arrays.asList("/test/node1","/test/node2","/test/node3")),paths);
}
