@Test public void removeRemovedProperty(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  mk.commit("/foo","^\"prop\":null",rev,null);
  try {
    mk.commit("/foo","^\"prop\":null",rev,null);
    fail("Must fail with conflict for removeRemovedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
