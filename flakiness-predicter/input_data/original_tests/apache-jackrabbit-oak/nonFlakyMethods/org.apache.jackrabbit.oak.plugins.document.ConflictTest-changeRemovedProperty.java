@Test public void changeRemovedProperty(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  mk.commit("/foo","^\"prop\":null",rev,null);
  try {
    mk.commit("/foo","^\"prop\":\"bar\"",rev,null);
    fail("Must fail with conflict for changeRemovedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
