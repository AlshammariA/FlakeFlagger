@Test public void testDuplicatedResourcesShouldBeSkipped() throws Exception {
  new GenericTestBuilder().processAndCompare("/repeatedResources.js","classpath:ro/isdc/wro/manager/repeated-out.js");
}
