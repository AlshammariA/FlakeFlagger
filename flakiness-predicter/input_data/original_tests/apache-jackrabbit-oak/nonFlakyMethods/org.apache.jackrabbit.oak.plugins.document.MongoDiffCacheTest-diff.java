@Test public void diff(){
  Revision from=Revision.fromString("r1-0-1");
  Revision to=Revision.fromString("r2-0-1");
  Diff diff=new Diff(from,to);
  diff.append("/","^\"foo\":{}");
  diff.append("/foo","^\"bar\":{}");
  diff.append("/foo/bar","-\"qux\"");
  assertEquals("^\"foo\":{}",diff.getChanges("/"));
  assertEquals("^\"bar\":{}",diff.getChanges("/foo"));
  assertEquals("-\"qux\"",diff.getChanges("/foo/bar"));
  assertEquals("",diff.getChanges("/baz"));
}
