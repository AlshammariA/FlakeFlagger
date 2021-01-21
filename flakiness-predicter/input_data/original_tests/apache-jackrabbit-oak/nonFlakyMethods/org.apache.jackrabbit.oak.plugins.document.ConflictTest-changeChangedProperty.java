@Test public void changeChangedProperty(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  mk.commit("/foo","^\"prop\":\"bar\"",rev,null);
  try {
    mk.commit("/foo","^\"prop\":\"baz\"",rev,null);
    fail("Must fail with conflict for changeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
