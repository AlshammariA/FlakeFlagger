@Test public void testNoDiff() throws Exception {
  assertDiff("a,b,c","a,b,c",Collections.<String>emptyList());
  assertDiff("a,b,c,d,f","a,b,f",Collections.<String>emptyList());
}
