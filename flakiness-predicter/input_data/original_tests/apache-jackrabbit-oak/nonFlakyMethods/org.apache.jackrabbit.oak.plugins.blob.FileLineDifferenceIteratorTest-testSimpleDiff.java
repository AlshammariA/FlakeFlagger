@Test public void testSimpleDiff() throws Exception {
  assertDiff("a,b","a,b,c",asList("c"));
  assertDiff("a,b","",Collections.<String>emptyList());
  assertDiff("","",Collections.<String>emptyList());
  assertDiff("","a",asList("a"));
  assertDiff("","a, b",asList("a","b"));
}
