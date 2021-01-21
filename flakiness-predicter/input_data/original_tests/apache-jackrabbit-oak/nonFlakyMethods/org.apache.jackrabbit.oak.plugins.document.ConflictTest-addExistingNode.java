@Test public void addExistingNode(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  mk.commit("/foo","+\"bar\":{}",rev,null);
  try {
    mk.commit("/foo","+\"bar\":{}",rev,null);
    fail("Must fail with conflict for addExistingNode");
  }
 catch (  MicroKernelException e) {
  }
}
