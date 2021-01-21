@Test public void testSubPropertyMultiAndEquals() throws Exception {
  Tree c=root.getTree("/").addChild("content");
  c.addChild("one").addChild("child").setProperty("prop","aaa");
  c.addChild("two").addChild("child").setProperty("prop",ImmutableList.of("aaa","bbb","ccc"),Type.STRINGS);
  c.addChild("three").addChild("child").setProperty("prop",ImmutableList.of("aaa","bbb"),Type.STRINGS);
  root.commit();
  assertQuery("//*[(child/@prop = 'aaa' and child/@prop = 'bbb' and child/@prop = 'ccc')]","xpath",ImmutableList.of("/content/two"));
}
