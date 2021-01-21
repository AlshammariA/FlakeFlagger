@Test public void testSubPropertyMultiAndLike() throws Exception {
  Tree c=root.getTree("/").addChild("content");
  c.addChild("one").addChild("child").setProperty("prop","aaaBoom");
  c.addChild("two").addChild("child").setProperty("prop",ImmutableList.of("aaaBoom","bbbBoom","cccBoom"),Type.STRINGS);
  c.addChild("three").addChild("child").setProperty("prop",ImmutableList.of("aaaBoom","bbbBoom"),Type.STRINGS);
  root.commit();
  assertQuery("//*[(jcr:like(child/@prop, 'aaa%') and jcr:like(child/@prop, 'bbb%') and jcr:like(child/@prop, 'ccc%'))]","xpath",ImmutableList.of("/content/two"));
}
