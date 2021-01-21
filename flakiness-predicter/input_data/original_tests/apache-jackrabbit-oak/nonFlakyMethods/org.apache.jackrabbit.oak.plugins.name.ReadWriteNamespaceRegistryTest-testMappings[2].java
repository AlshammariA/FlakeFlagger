@Test public void testMappings() throws Exception {
  final ContentSession session=createContentSession();
  final Root root=session.getLatestRoot();
  NamespaceRegistry r=new ReadWriteNamespaceRegistry(root){
    @Override protected Root getWriteRoot(){
      return session.getLatestRoot();
    }
    @Override protected void refresh(){
      root.refresh();
    }
  }
;
  assertEquals("",r.getURI(""));
  assertEquals("http://www.jcp.org/jcr/1.0",r.getURI("jcr"));
  assertEquals("http://www.jcp.org/jcr/nt/1.0",r.getURI("nt"));
  assertEquals("http://www.jcp.org/jcr/mix/1.0",r.getURI("mix"));
  assertEquals("http://www.w3.org/XML/1998/namespace",r.getURI("xml"));
  assertEquals("",r.getPrefix(""));
  assertEquals("jcr",r.getPrefix("http://www.jcp.org/jcr/1.0"));
  assertEquals("nt",r.getPrefix("http://www.jcp.org/jcr/nt/1.0"));
  assertEquals("mix",r.getPrefix("http://www.jcp.org/jcr/mix/1.0"));
  assertEquals("xml",r.getPrefix("http://www.w3.org/XML/1998/namespace"));
  r.registerNamespace("p","n");
  assertEquals(r.getURI("p"),"n");
  assertEquals(r.getPrefix("n"),"p");
  r.registerNamespace("p2","n2");
  assertEquals(r.getURI("p2"),"n2");
  assertEquals(r.getPrefix("n2"),"p2");
}
