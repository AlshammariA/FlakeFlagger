@Test public void testSkippingActionExInBadBegin() throws Exception {
  doTest("badBegin2.xml",null,ActionException.class);
}
