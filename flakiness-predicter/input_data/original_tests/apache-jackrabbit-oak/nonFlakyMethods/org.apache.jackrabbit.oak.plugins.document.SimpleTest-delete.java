@Test public void delete(){
  DocumentMK mk=createMK();
  DocumentNodeStore ns=mk.getNodeStore();
  mk.commit("/","+\"testDel\":{\"name\": \"Hello\"}",null,null);
  mk.commit("/testDel","+\"a\":{\"name\": \"World\"}",null,null);
  mk.commit("/testDel","+\"b\":{\"name\": \"!\"}",null,null);
  String r1=mk.commit("/testDel","+\"c\":{\"name\": \"!\"}",null,null);
  DocumentNodeState n=ns.getNode("/testDel",Revision.fromString(r1));
  assertNotNull(n);
  Children c=ns.getChildren(n,null,Integer.MAX_VALUE);
  assertEquals(3,c.children.size());
  String r2=mk.commit("/testDel","-\"c\"",null,null);
  n=ns.getNode("/testDel",Revision.fromString(r2));
  assertNotNull(n);
  c=ns.getChildren(n,null,Integer.MAX_VALUE);
  assertEquals(2,c.children.size());
  String r3=mk.commit("/","-\"testDel\"",null,null);
  n=ns.getNode("/testDel",Revision.fromString(r3));
  assertNull(n);
}
