@Test public void testDiffWithExtraEntriesInMarked() throws IOException {
  assertDiff("a,b","a,b,c, e, h",asList("c","e","h"));
  assertDiff("a,b,d,e","a,b,c",asList("c"));
  assertDiff("a,b,d,e,f","a,b,c,f",asList("c"));
  assertDiff("a,b,d,e,f","a,b,c,f, h",asList("c","h"));
  assertDiff("3,7","2,3,5,9",asList("2","5","9"));
}
