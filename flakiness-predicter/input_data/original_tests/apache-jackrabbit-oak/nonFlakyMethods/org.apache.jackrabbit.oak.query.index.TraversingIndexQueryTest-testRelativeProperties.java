@Test public void testRelativeProperties() throws Exception {
  root.getTree("/").addChild("content").addChild("node1").setProperty("prop",128);
  root.commit();
  assertQuery("//*[(@prop > 1)]","xpath",ImmutableList.of("/content/node1"));
  assertQuery("//*[(@prop > 2)]","xpath",ImmutableList.of("/content/node1"));
  assertQuery("//*[(@prop > 20)]","xpath",ImmutableList.of("/content/node1"));
  assertQuery("//*[(@prop > 100)]","xpath",ImmutableList.of("/content/node1"));
  assertQuery("//*[(@prop > 200)]","xpath",new ArrayList<String>());
  assertQuery("//*[(@prop > 1000)]","xpath",new ArrayList<String>());
  assertQuery("//*[(*/@prop > 1)]","xpath",ImmutableList.of("/content"));
  assertQuery("//*[(*/@prop > 2)]","xpath",ImmutableList.of("/content"));
  assertQuery("//*[(*/@prop > 20)]","xpath",ImmutableList.of("/content"));
  assertQuery("//*[(*/@prop > 100)]","xpath",ImmutableList.of("/content"));
  assertQuery("//*[(*/@prop > 200)]","xpath",new ArrayList<String>());
  assertQuery("//*[(*/@prop > 1000)]","xpath",new ArrayList<String>());
}
