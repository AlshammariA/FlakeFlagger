@Test public void existsInHeadRevision() throws Exception {
  mk.commit("/","+\"a\" : {}",null,"Add /a");
  mk.commit("/a","+\"b\" : {}",null,"Add /a/b");
  boolean exists=mk.nodeExists("/a",null);
  assertTrue("The node a is not found in the head revision!",exists);
}
