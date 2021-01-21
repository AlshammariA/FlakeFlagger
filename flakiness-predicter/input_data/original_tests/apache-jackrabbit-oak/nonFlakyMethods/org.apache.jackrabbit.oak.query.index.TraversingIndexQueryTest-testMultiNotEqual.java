@Test public void testMultiNotEqual() throws Exception {
  Tree c=root.getTree("/").addChild("content");
  c.addChild("one").setProperty("prop","value");
  c.addChild("two").setProperty("prop",ImmutableList.of("aaa","value","bbb"),Type.STRINGS);
  c.addChild("three").setProperty("prop",ImmutableList.of("aaa","bbb","ccc"),Type.STRINGS);
  root.commit();
  assertQuery("//*[@prop != 'value']","xpath",ImmutableList.of("/content/two","/content/three"));
}
