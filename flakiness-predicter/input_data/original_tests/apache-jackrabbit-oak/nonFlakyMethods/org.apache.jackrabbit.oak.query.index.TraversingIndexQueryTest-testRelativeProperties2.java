@Test public void testRelativeProperties2() throws Exception {
  Tree t=root.getTree("/").addChild("content").addChild("nodes");
  Tree a=t.addChild("a");
  a.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  Tree b=a.addChild("b");
  b.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  Tree c=b.addChild("c");
  c.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  Tree d1=c.addChild("d1");
  d1.setProperty("prop",10);
  d1.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  Tree d2=c.addChild("d2");
  d2.setProperty("prop",20);
  d2.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  Tree d3=c.addChild("d3");
  d3.setProperty("prop",30);
  d3.setProperty(JCR_PRIMARYTYPE,"nt:unstructured",Type.NAME);
  root.commit();
  assertQuery("/jcr:root/content/nodes//*[(*/*/*/@prop >= 9)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//element(*, nt:unstructured)[(*/*/*/@prop >= 9)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//*[(*/*/*/@prop >= 10)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//element(*, nt:unstructured)[(*/*/*/@prop >= 10)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//*[(*/*/*/@prop >= 15)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//element(*, nt:unstructured)[(*/*/*/@prop >= 15)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//*[(*/*/*/@prop >= 20)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//element(*, nt:unstructured)[(*/*/*/@prop >= 20)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//*[(*/*/*/@prop >= 30)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
  assertQuery("/jcr:root/content/nodes//element(*, nt:unstructured)[(*/*/*/@prop >= 30)]","xpath",ImmutableList.of("/content/nodes/a","/content/nodes/a/b","/content/nodes/a/b/c"));
}
