@Test public void testSkippingRuntimeExInBadBegin() throws Exception {
  doTest("badBegin1.xml",null,IllegalStateException.class);
}
