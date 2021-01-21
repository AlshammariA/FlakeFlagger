@Test public void diff(){
  DocumentMK mk=createMK();
  String rev0=mk.getHeadRevision();
  String rev1=mk.commit("/","+\"t1\":{}",null,null);
  String rev2=mk.commit("/","+\"t2\":{}",null,null);
  String rev3=mk.commit("/","+\"t3\":{}",null,null);
  String rev4=mk.commit("/","^\"t3/x\":1",null,null);
  String r0=mk.getNodes("/",rev0,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\":childNodeCount\":0}",r0);
  String r1=mk.getNodes("/",rev1,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"t1\":{},\":childNodeCount\":1}",r1);
  String r2=mk.getNodes("/",rev2,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"t1\":{},\"t2\":{},\":childNodeCount\":2}",r2);
  String r3=mk.getNodes("/",rev3,0,0,Integer.MAX_VALUE,null);
  assertEquals("{\"t1\":{},\"t2\":{},\"t3\":{},\":childNodeCount\":3}",r3);
  String diff01=mk.diff(rev0,rev1,"/",0).trim();
  assertEquals("+\"/t1\":{}",diff01);
  String diff12=mk.diff(rev1,rev2,"/",0).trim();
  assertEquals("+\"/t2\":{}",diff12);
  String diff23=mk.diff(rev2,rev3,"/",0).trim();
  assertEquals("+\"/t3\":{}",diff23);
  String diff13=mk.diff(rev1,rev3,"/",0).trim();
  assertEquals("+\"/t2\":{}\n+\"/t3\":{}",diff13);
  String diff34=mk.diff(rev3,rev4,"/",0).trim();
  assertEquals("^\"/t3\":{}",diff34);
  mk.dispose();
}
