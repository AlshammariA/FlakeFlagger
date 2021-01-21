@Test public void diffWithDepth(){
  String head=mk.getHeadRevision();
  String r1=mk.commit("/","+\"a\" : { \"l\": 1, \"x\": { \"l\": 2, \"y\": {} } }",head,null);
  String r2=mk.commit("/",">\"a\" : \"b\"",r1,null);
  assertEquals("+\"/b\":{\"l\":1}",mk.diff(r1,r2,"/b",0).trim());
  assertEquals("+\"/b\":{\"l\":1,\"x\":{\"l\":2}}",mk.diff(r1,r2,"/b",1).trim());
  assertEquals("+\"/b\":{\"l\":1,\"x\":{\"l\":2,\"y\":{}}}",mk.diff(r1,r2,"/b",-1).trim());
}
