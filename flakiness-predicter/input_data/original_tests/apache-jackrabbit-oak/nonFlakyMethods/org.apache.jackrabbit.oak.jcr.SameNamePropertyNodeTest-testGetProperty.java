@Test public void testGetProperty() throws Exception {
  assertTrue(p.isSame(testRootNode.getProperty(sameName)));
  assertFalse(p.isSame(n));
}
