@Test public void removeRemovedNode(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  mk.commit("/","-\"foo\"",rev,null);
  try {
    mk.commit("/","-\"foo\"",rev,null);
    fail("Must fail with conflict for removeRemovedNode");
  }
 catch (  MicroKernelException e) {
  }
}
