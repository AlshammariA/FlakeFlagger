@Test public void query() throws Exception {
  Tree t=root.getTree("/");
  t.setProperty("pid","foo");
  t.addChild("a").setProperty("pid","foo");
  t.addChild("b").setProperty("pid","bar");
  t.addChild("c").setProperty("pid","foo");
  t.addChild("d").setProperty("cid","foo");
  Tree content=t.addChild("content");
  content.addChild("x").setProperty("pid","foo");
  content.addChild("y").setProperty("pid","baz");
  content.addChild("z").setProperty("pid","bar");
  root.commit();
  setTravesalEnabled(false);
  assertQuery("select [jcr:path] from [nt:base] where [cid] = 'foo'",new ArrayList<String>());
  assertQuery("select [jcr:path] from [nt:base] where [pid] = 'foo'",ImmutableList.of("/","/a","/c","/content/x"));
  assertQuery("select [jcr:path] from [nt:base] where [pid] = 'bar'",ImmutableList.of("/b","/content/z"));
  assertQuery("select [jcr:path] from [nt:base] where [pid] = 'baz'",ImmutableList.of("/content/y"));
  setTravesalEnabled(true);
}
