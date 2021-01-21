@Test public void addExistingProperty(){
  String rev=mk.commit("/","+\"foo\":{}",null,null);
  mk.commit("/foo","^\"prop\":\"value\"",rev,null);
  try {
    mk.commit("/foo","^\"prop\":\"value\"",rev,null);
    fail("Must fail with conflict for addExistingProperty");
  }
 catch (  MicroKernelException e) {
  }
}
