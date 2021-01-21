@Test public void testOakToJcr(){
  assertEquals("/foo:bar",npMapper.getJcrPath("/oak-foo:bar"));
  assertEquals("/foo:bar/quu:qux",npMapper.getJcrPath("/oak-foo:bar/oak-quu:qux"));
  assertEquals("foo:bar",npMapper.getJcrPath("oak-foo:bar"));
  assertEquals(".",npMapper.getJcrPath(""));
  try {
    npMapper.getJcrPath("{http://www.jcp.org/jcr/nt/1.0}unstructured");
    fail("expanded name should not be accepted");
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    npMapper.getJcrPath("foobar/{http://www.jcp.org/jcr/1.0}content");
    fail("expanded name should not be accepted");
  }
 catch (  IllegalArgumentException expected) {
  }
}
