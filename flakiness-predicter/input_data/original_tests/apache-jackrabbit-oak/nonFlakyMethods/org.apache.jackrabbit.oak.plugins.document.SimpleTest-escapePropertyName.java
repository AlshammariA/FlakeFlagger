@Test public void escapePropertyName(){
  DocumentMK mk=createMK();
  String rev=mk.commit("/","+\"test1\":{\"name.first\": \"Hello\"} +\"test2\":{\"_id\": \"a\"} +\"test3\":{\"$x\": \"1\"}",null,null);
  String test1=mk.getNodes("/test1",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"name.first\":\"Hello\",\":childNodeCount\":0}",test1);
  String test2=mk.getNodes("/test2",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"_id\":\"a\",\":childNodeCount\":0}",test2);
  String test3=mk.getNodes("/test3",rev,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"$x\":\"1\",\":childNodeCount\":0}",test3);
  mk.dispose();
}
