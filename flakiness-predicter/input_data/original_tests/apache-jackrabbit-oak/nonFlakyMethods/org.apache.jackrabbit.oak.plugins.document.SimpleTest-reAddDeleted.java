@Test public void reAddDeleted(){
  DocumentMK mk=createMK();
  String rev0=mk.getHeadRevision();
  String rev1=mk.commit("/","+\"test\":{\"name\": \"Hello\"} ^ \"x\": 1",null,null);
  String rev2=mk.commit("/","-\"test\" ^ \"x\": 2",null,null);
  String rev3=mk.commit("/","+\"test\":{\"name\": \"Hallo\"} ^ \"x\": 3",null,null);
  String test0=mk.getNodes("/test",rev0,0,0,Integer.MAX_VALUE,null);
  assertNull(null,test0);
  String test1=mk.getNodes("/test",rev1,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"name\":\"Hello\",\":childNodeCount\":0}",test1);
  String test2=mk.getNodes("/test",rev2,0,0,Integer.MAX_VALUE,null);
  assertNull(null,test2);
  String test3=mk.getNodes("/test",rev3,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"name\":\"Hallo\",\":childNodeCount\":0}",test3);
  mk.dispose();
}
