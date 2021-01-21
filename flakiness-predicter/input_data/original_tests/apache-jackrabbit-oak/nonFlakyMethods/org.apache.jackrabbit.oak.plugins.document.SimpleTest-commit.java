@Test public void commit(){
  DocumentMK mk=createMK();
  DocumentNodeStore ns=mk.getNodeStore();
  String rev=mk.commit("/","+\"test\":{\"name\": \"Hello\"}",null,null);
  String test=mk.getNodes("/test",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"name\":\"Hello\",\":childNodeCount\":0}",test);
  String r0=mk.commit("/test","+\"a\":{\"name\": \"World\"}",null,null);
  String r1=mk.commit("/test","+\"b\":{\"name\": \"!\"}",null,null);
  test=mk.getNodes("/test",r0,0,0,Integer.MAX_VALUE,null);
  DocumentNodeState n=ns.getNode("/",Revision.fromString(r0));
  assertNotNull(n);
  Children c=ns.getChildren(n,null,Integer.MAX_VALUE);
  assertEquals("[test]",c.toString());
  n=ns.getNode("/test",Revision.fromString(r1));
  assertNotNull(n);
  c=ns.getChildren(n,null,Integer.MAX_VALUE);
  assertEquals("[a, b]",c.toString());
  rev=mk.commit("","^\"/test\":1",null,null);
  test=mk.getNodes("/",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"test\":1,\"test\":{},\":childNodeCount\":1}",test);
  mk.dispose();
}
