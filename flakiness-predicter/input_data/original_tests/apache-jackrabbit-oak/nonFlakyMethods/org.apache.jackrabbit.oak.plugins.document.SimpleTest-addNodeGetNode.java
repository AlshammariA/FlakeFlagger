@Test public void addNodeGetNode(){
  DocumentMK mk=new DocumentMK.Builder().open();
  DocumentStore s=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  Revision rev=Revision.fromString(mk.getHeadRevision());
  DocumentNodeState n=new DocumentNodeState(ns,"/test",rev);
  n.setProperty("name","\"Hello\"");
  UpdateOp op=n.asOperation(true);
  NodeDocument.setRevision(op,rev,"c");
  assertTrue(s.create(Collection.NODES,Lists.newArrayList(op)));
  DocumentNodeState n2=ns.getNode("/test",rev);
  assertNotNull(n2);
  PropertyState p=n2.getProperty("name");
  assertNotNull(p);
  assertEquals("Hello",p.getValue(Type.STRING));
  mk.dispose();
}
