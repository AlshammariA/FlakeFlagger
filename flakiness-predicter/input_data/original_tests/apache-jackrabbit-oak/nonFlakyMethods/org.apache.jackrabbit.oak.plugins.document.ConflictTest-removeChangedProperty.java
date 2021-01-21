@Test public void removeChangedProperty(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  mk.commit("/foo","^\"prop\":\"bar\"",rev,null);
  try {
    mk.commit("/foo","^\"prop\":null",rev,null);
    fail("Must fail with conflict for removeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
