@Test public void nodeIdentifier(){
  DocumentMK mk=createMK(true);
  String rev0=mk.getHeadRevision();
  String rev1=mk.commit("/","+\"test\":{}",null,null);
  String rev2=mk.commit("/test","+\"a\":{}",null,null);
  String rev3=mk.commit("/test","+\"b\":{}",null,null);
  String rev4=mk.commit("/test","^\"a/x\":1",null,null);
  String r0=mk.getNodes("/",rev0,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/@r0-0-1\",\":childNodeCount\":0}",r0);
  String r1=mk.getNodes("/",rev1,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/@r1-0-1\",\"test\":{},\":childNodeCount\":1}",r1);
  String r2=mk.getNodes("/",rev2,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/@r2-0-1\",\"test\":{},\":childNodeCount\":1}",r2);
  String r3;
  r3=mk.getNodes("/",rev3,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/@r3-0-1\",\"test\":{},\":childNodeCount\":1}",r3);
  r3=mk.getNodes("/test",rev3,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/test@r3-0-1\",\"a\":{},\"b\":{},\":childNodeCount\":2}",r3);
  String r4;
  r4=mk.getNodes("/",rev4,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/@r4-0-1\",\"test\":{},\":childNodeCount\":1}",r4);
  r4=mk.getNodes("/test",rev4,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/test@r4-0-1\",\"a\":{},\"b\":{},\":childNodeCount\":2}",r4);
  r4=mk.getNodes("/test/a",rev4,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/test/a@r4-0-1\",\"x\":1,\":childNodeCount\":0}",r4);
  r4=mk.getNodes("/test/b",rev4,0,0,Integer.MAX_VALUE,":id");
  assertEquals("{\":id\":\"/test/b@r3-0-1\",\":childNodeCount\":0}",r4);
  mk.dispose();
}
