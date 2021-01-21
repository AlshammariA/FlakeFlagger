@Test public void changeChangedPropertyTwoBranches(){
  String rev=mk.commit("/","+\"foo\":{\"prop\":\"value\"}",null,null);
  String b1=mk.branch(rev);
  String b2=mk.branch(rev);
  b1=mk.commit("/foo","^\"prop\":\"bar\"",b1,null);
  mk.merge(b1,null);
  b2=mk.commit("/foo","^\"prop\":\"baz\"",b2,null);
  try {
    mk.merge(b2,null);
    fail("Must fail with conflict for changeChangedProperty");
  }
 catch (  MicroKernelException e) {
  }
}
