@Test public void testLowercaseOnArrays() throws Exception {
  Tree content=root.getTree("/").addChild("content");
  content.setProperty("array",Arrays.asList("X","Y"),Type.STRINGS);
  root.commit();
  assertQuery("//*[jcr:like(fn:lower-case(@array), '%x%')]","xpath",Arrays.asList("/content"));
}
