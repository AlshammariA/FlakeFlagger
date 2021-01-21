@Test public void rollbackAfterConflict(){
  DocumentMK mk1=createMK(1);
  DocumentMK mk2=createMK(2);
  String m1r0=mk1.getHeadRevision();
  String m2r0=mk2.getHeadRevision();
  mk1.commit("/","+\"test\":{}",m1r0,null);
  try {
    mk2.commit("/","+\"a\": {} +\"test\":{}",m2r0,null);
    fail();
  }
 catch (  MicroKernelException e) {
  }
  mk2.commit("/","+\"a\": {}",null,null);
  mk1.dispose();
  mk2.dispose();
}
