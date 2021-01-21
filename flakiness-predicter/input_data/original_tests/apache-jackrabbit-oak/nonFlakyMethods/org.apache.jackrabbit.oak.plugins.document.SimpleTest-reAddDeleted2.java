@Test public void reAddDeleted2(){
  DocumentMK mk=createMK();
  String rev=mk.commit("/","+\"test\":{\"x\":\"1\",\"child\": {}}",null,null);
  rev=mk.commit("/","-\"test\"",rev,null);
  rev=mk.commit("/","+\"test\":{}  +\"test2\": {}",null,null);
  String test=mk.getNodes("/test",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\":childNodeCount\":0}",test);
  String test2=mk.getNodes("/test2",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\":childNodeCount\":0}",test2);
  mk.dispose();
}
