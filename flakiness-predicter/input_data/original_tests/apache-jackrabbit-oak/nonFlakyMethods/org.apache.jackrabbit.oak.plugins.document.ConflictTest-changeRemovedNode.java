@Test public void changeRemovedNode(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  mk.commit("/","-\"foo\"",rev,null);
  try {
    mk.commit("/foo","^\"prop\":\"value\"",rev,null);
    fail("Must fail with conflict for changeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
