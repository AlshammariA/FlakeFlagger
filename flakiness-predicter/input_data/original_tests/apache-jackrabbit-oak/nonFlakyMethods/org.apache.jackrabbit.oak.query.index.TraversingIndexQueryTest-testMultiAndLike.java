@Test public void testMultiAndLike() throws Exception {
  Tree c=root.getTree("/").addChild("content");
  c.addChild("one").setProperty("prop","aaaBoom");
  c.addChild("two").setProperty("prop",ImmutableList.of("aaaBoom","bbbBoom","cccBoom"),Type.STRINGS);
  c.addChild("three").setProperty("prop",ImmutableList.of("aaaBoom","bbbBoom"),Type.STRINGS);
  root.commit();
  assertQuery("//*[(jcr:like(@prop, 'aaa%') and jcr:like(@prop, 'bbb%') and jcr:like(@prop, 'ccc%'))]","xpath",ImmutableList.of("/content/two"));
}
