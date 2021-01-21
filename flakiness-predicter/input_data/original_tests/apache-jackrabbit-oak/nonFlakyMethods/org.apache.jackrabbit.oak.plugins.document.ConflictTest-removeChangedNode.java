@Test public void removeChangedNode(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  mk.commit("/foo","^\"prop\":\"value\"",rev,null);
  try {
    mk.commit("/","-\"foo\"",rev,null);
    fail("Must fail with conflict for removeChangedNode");
  }
 catch (  MicroKernelException e) {
  }
}
