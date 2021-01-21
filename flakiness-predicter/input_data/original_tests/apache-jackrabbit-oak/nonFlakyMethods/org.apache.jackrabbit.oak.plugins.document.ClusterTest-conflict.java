@Test public void conflict(){
  DocumentMK mk1=createMK(1,0);
  DocumentMK mk2=createMK(2,0);
  String m1r0=mk1.getHeadRevision();
  String m2r0=mk2.getHeadRevision();
  mk1.commit("/","+\"test\":{}",m1r0,null);
  try {
    mk2.commit("/","+\"test\":{}",m2r0,null);
    fail();
  }
 catch (  MicroKernelException e) {
  }
  mk1.runBackgroundOperations();
  mk2.runBackgroundOperations();
  String n1=mk1.getNodes("/",mk1.getHeadRevision(),0,0,10,null);
  String n2=mk2.getNodes("/",mk2.getHeadRevision(),0,0,10,null);
  assertEquals(n1,n2);
  mk1.dispose();
  mk2.dispose();
}
