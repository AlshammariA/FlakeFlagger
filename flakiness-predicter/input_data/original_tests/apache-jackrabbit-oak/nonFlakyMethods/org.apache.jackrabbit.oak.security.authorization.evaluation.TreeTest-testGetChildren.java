@Test public void testGetChildren() throws Exception {
  for (  Tree t : testRoot.getTree("/a").getChildren()) {
    if (!"b".equals(t.getName())) {
      fail("Child " + t.getName() + " should not be accessible.");
    }
  }
}
