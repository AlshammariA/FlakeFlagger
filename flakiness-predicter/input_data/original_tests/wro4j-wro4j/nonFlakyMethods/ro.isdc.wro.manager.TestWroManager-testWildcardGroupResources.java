@Test public void testWildcardGroupResources() throws Exception {
  new GenericTestBuilder().processAndCompare("/wildcardResources.js","classpath:ro/isdc/wro/manager/wildcard-out.js");
}
