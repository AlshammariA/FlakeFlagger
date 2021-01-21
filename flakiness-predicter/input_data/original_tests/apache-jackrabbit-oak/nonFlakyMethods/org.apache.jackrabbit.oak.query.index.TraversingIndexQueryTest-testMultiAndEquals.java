@Test public void testMultiAndEquals() throws Exception {
  Tree c=root.getTree("/").addChild("content");
  c.addChild("one").setProperty("prop","aaa");
  c.addChild("two").setProperty("prop",ImmutableList.of("aaa","bbb","ccc"),Type.STRINGS);
  c.addChild("three").setProperty("prop",ImmutableList.of("aaa","bbb"),Type.STRINGS);
  root.commit();
  assertQuery("//*[(@prop = 'aaa' and @prop = 'bbb' and @prop = 'ccc')]","xpath",ImmutableList.of("/content/two"));
}
