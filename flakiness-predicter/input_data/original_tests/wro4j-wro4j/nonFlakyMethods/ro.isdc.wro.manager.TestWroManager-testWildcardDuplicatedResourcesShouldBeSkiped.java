@Test public void testWildcardDuplicatedResourcesShouldBeSkiped() throws Exception {
  new GenericTestBuilder().processAndCompare("/wildcardRepeatedResources.js","classpath:ro/isdc/wro/manager/wildcardRepeated-out.js");
}
